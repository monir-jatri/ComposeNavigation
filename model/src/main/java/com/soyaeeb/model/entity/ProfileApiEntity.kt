package com.soyaeeb.model.entity

 data class ProfileApiEntity(
     val id: Int = 0,
     val name: String = "",
     val login: String = "",
     val avatar_url : String = "",
     val followers: Int = 0,
     val following: Int = 0,
     val bio: String = "",
     val public_repos: Int = 0,
 )