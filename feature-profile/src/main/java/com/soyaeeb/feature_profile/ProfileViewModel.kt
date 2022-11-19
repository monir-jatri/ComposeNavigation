package com.soyaeeb.feature_profile

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soyaeeb.common.util.LoadingScreen
import com.soyaeeb.domain.ApiResult
import com.soyaeeb.domain.usecase.FetchProfileApiUseCase
import com.soyaeeb.domain.usecase.FetchRepoListByUserUseCase
import com.soyaeeb.model.entity.ProfileApiEntity
import com.soyaeeb.model.entity.RepoItemApiEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface UiState {
    data class GetProfileInfoState(
        val profileApiEntity: ProfileApiEntity
    ) : UiState
}

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val fetchProfileApiUseCase: FetchProfileApiUseCase
): ViewModel() {
    private val _profileInfoState = MutableStateFlow(UiState.GetProfileInfoState(ProfileApiEntity()))
    val profileInfoState = _profileInfoState.asStateFlow()

    private val _visibleScreenState = MutableStateFlow(LoadingScreen.IDLE)
    val visibleScreenState = _visibleScreenState.asStateFlow()

    init {
        getProfileInfo()
    }

    private fun getProfileInfo(){
        viewModelScope.launch {
            fetchProfileApiUseCase.invoke(FetchProfileApiUseCase.Params("soyaeeb-monir")).collect{ apiResult ->
                when(apiResult){
                    is ApiResult.Loading -> _visibleScreenState.value = LoadingScreen.LOADING
                    is ApiResult.Success -> {
                        _visibleScreenState.value = LoadingScreen.SUCCESS
                       _profileInfoState.value = UiState.GetProfileInfoState(apiResult.data)
                    }
                    is ApiResult.Error -> _visibleScreenState.value = LoadingScreen.ERROR
                }
            }
        }
    }
}