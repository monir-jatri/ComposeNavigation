package com.soyaeeb.model.reponse

data class RepoItemApiResponse(
    val id: Long?,
    val name: String?,
    val full_name: String?,
    val description: String?,
    val fork: Boolean?,
    val language: String?,
    val fork_count: Int?,
    val stargazers_count: Int?,
    val owner: OwnerApiResponse?,
)

data class OwnerApiResponse(
    val id: Int?,
    val login: String?,
    val avatar_url: String?,
    val type: String?
)
