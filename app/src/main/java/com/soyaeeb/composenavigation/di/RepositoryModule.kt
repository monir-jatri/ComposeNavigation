package com.soyaeeb.composenavigation.di

import com.soyaeeb.data.repoimpl.RemoteRepoImpl
import com.soyaeeb.domain.repository.RemoteRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface RepositoryModule {
    @Binds
    fun bindRemoteRepository(remoteRepository: RemoteRepoImpl): RemoteRepository
}