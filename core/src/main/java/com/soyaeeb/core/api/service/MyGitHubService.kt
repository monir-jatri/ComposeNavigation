package com.soyaeeb.core.api.service

import com.soyaeeb.model.reponse.ProfileApiResponse
import com.soyaeeb.model.reponse.RepoItemApiResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface MyGitHubService {
    @GET("users/{username}/repos")
    suspend fun fetchRepoListByUser(
        @Path("username")username:String
    ): Response<List<RepoItemApiResponse>>

    @GET("users/{username}")
    suspend fun fetchProfile(
        @Path("username")username:String
    ):Response<ProfileApiResponse>
}