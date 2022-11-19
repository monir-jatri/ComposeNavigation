package com.soyaeeb.domain.usecase

import com.soyaeeb.domain.ApiResult
import com.soyaeeb.domain.base.ApiUseCase
import com.soyaeeb.domain.repository.RemoteRepository
import com.soyaeeb.model.entity.ProfileApiEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchProfileApiUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository
): ApiUseCase<FetchProfileApiUseCase.Params, ProfileApiEntity> {
    data class Params(
        val username: String
    )

    override suspend fun invoke(params: Params): Flow<ApiResult<ProfileApiEntity>> {
        return remoteRepository.fetchProfile(params.username)
    }

}