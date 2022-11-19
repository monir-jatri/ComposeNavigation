package com.soyaeeb.data.mapper

import com.soyaeeb.model.entity.OwnerApiEntity
import com.soyaeeb.model.entity.RepoItemApiEntity
import com.soyaeeb.model.reponse.RepoItemApiResponse
import javax.inject.Inject

class RepoItemApiMapper @Inject constructor() : Mapper<List<RepoItemApiResponse>,List<RepoItemApiEntity>> {
    override fun mapFromApiResponse(type: List<RepoItemApiResponse>): List<RepoItemApiEntity> {
        return type.map {
                RepoItemApiEntity(
                    id = it.id ?:0L,
                    name = it.name ?:"",
                    description = it.description ?:"",
                    language = it.language ?:"",
                    fork_count = it.fork_count ?:0,
                    stargazers_count = it.stargazers_count ?:0,
                    full_name = it.full_name ?:"",
                    owner = OwnerApiEntity(
                        id = it.owner?.id ?:0,
                        login = it.owner?.login ?:"",
                        avatar_url = it.owner?.avatar_url ?:""
                    )
                )
            }
    }
}