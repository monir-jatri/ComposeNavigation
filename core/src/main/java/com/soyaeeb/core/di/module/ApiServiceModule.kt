package com.soyaeeb.core.di.module
import com.soyaeeb.core.api.service.MyGitHubService
import com.soyaeeb.core.di.qualifier.AppBaseUrl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object ApiServiceModule {

    @Provides
    @Singleton
    fun provideOfflineTicketApiService(@AppBaseUrl retrofit: Retrofit) : MyGitHubService {
        return retrofit.create(MyGitHubService::class.java)
    }

}