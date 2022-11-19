package com.soyaeeb.features_repolist

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.soyaeeb.domain.ApiResult
import com.soyaeeb.domain.usecase.FetchRepoListByUserUseCase
import com.soyaeeb.model.entity.RepoItemApiEntity
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

sealed interface UiState {
    data class GetRepoListState(
        val repoList: List<RepoItemApiEntity>
    ) : UiState
}

sealed interface UiAction{
    object OnRepoItemClick : UiAction
}


@HiltViewModel
class RepoViewModel @Inject constructor(
    private val repoListUseCase: FetchRepoListByUserUseCase
): ViewModel() {

    private val _repoListState = MutableStateFlow(UiState.GetRepoListState(emptyList()))
    val repoListState = _repoListState.asStateFlow()

    init {
        getRepoList()
    }

    private fun getRepoList(){
        viewModelScope.launch {
            repoListUseCase.invoke(FetchRepoListByUserUseCase.Params("soyaeeb-monir")).collect{ apiResult ->
                when(apiResult){
                    is ApiResult.Loading -> {}
                    is ApiResult.Success -> {
                        _repoListState.value = UiState.GetRepoListState(apiResult.data)
                    }
                    is ApiResult.Error -> {}
                }
            }
        }
    }
}