package com.soyaeeb.model.reponse

 data class ProfileApiResponse(
     val id: Int?,
     val login: String?,
     val name: String?,
     val email: String?,
     val company: String?,
     val avatar_url : String?,
     val followers: Int?,
     val following: Int?,
     val bio: String?,
     val public_repos: Int?,
 )