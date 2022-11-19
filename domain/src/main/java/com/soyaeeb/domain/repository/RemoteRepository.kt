package com.soyaeeb.domain.repository

import com.soyaeeb.domain.ApiResult
import com.soyaeeb.model.entity.ProfileApiEntity
import com.soyaeeb.model.entity.RepoItemApiEntity
import kotlinx.coroutines.flow.Flow

interface RemoteRepository {
  suspend fun fetchRepoListByUser(username: String) : Flow<ApiResult<List<RepoItemApiEntity>>>
  suspend fun fetchProfile(username: String) : Flow<ApiResult<ProfileApiEntity>>
}