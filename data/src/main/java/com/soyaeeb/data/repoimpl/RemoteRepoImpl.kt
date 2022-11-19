package com.soyaeeb.data.repoimpl

import com.soyaeeb.core.api.service.MyGitHubService
import com.soyaeeb.data.mapper.ProfileApiMapper
import com.soyaeeb.data.mapper.RepoItemApiMapper
import com.soyaeeb.data.mapper.mapFromApiResponse
import com.soyaeeb.data.wrapper.NetworkBoundResource
import com.soyaeeb.domain.ApiResult
import com.soyaeeb.domain.repository.RemoteRepository
import com.soyaeeb.model.entity.ProfileApiEntity
import com.soyaeeb.model.entity.RepoItemApiEntity
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class RemoteRepoImpl @Inject constructor(
    private val myGithubService: MyGitHubService,
    private val repoItemApiMapper: RepoItemApiMapper,
    private val profileApiMapper: ProfileApiMapper,
    private val networkBoundResource: NetworkBoundResource,
): RemoteRepository {
    override suspend fun fetchRepoListByUser(username: String): Flow<ApiResult<List<RepoItemApiEntity>>> {
       return mapFromApiResponse(
            apiResult = networkBoundResource.downloadData {
                myGithubService.fetchRepoListByUser(username)
            },
            mapper = repoItemApiMapper
        )
    }

    override suspend fun fetchProfile(username: String): Flow<ApiResult<ProfileApiEntity>> {
        return mapFromApiResponse(
            apiResult = networkBoundResource.downloadData {
                myGithubService.fetchProfile(username)
            },
            mapper = profileApiMapper
        )
    }
}
