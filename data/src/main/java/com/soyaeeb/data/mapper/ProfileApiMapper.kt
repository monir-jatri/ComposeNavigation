package com.soyaeeb.data.mapper

import com.soyaeeb.model.entity.ProfileApiEntity
import com.soyaeeb.model.reponse.ProfileApiResponse
import javax.inject.Inject

class ProfileApiMapper @Inject constructor() : Mapper<ProfileApiResponse, ProfileApiEntity>{
    override fun mapFromApiResponse(type: ProfileApiResponse): ProfileApiEntity {
        return ProfileApiEntity(
            id = type.id ?: 0,
            name = type.name ?:"",
            login = type.login ?:"",
            avatar_url = type.avatar_url ?:"",
            followers = type.followers ?: 0,
            following = type.following ?:0,
            bio = type.bio ?:"",
            public_repos = type.public_repos ?:0
        )
    }
}