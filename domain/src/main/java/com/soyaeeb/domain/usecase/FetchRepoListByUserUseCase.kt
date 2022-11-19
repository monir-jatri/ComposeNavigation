package com.soyaeeb.domain.usecase

import com.soyaeeb.domain.ApiResult
import com.soyaeeb.domain.base.ApiUseCase
import com.soyaeeb.domain.repository.RemoteRepository
import com.soyaeeb.model.entity.RepoItemApiEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FetchRepoListByUserUseCase @Inject constructor(
    private val remoteRepository: RemoteRepository
): ApiUseCase<FetchRepoListByUserUseCase.Params,List<RepoItemApiEntity>> {
    data class Params(
        val username: String = "soyaeeb-monir"
    )

    override suspend fun invoke(params: Params): Flow<ApiResult<List<RepoItemApiEntity>>> {
        return remoteRepository.fetchRepoListByUser(params.username)
    }

}