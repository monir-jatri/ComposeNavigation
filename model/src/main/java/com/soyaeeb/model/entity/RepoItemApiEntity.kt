package com.soyaeeb.model.entity

data class RepoItemApiEntity(
    val id: Long,
    val name: String,
    val description: String,
    val language: String,
    val fork_count: Int,
    val stargazers_count: Int,
    val full_name: String,
    val owner: OwnerApiEntity,
)

data class OwnerApiEntity(
    val id: Int,
    val login: String,
    val avatar_url: String,
)
