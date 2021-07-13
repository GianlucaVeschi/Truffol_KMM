package com.example.truffol_kmm.android.di

import com.example.truffol_kmm.datasource.network.KtorClientFactory
import com.example.truffol_kmm.datasource.network.TruffleService
import com.example.truffol_kmm.datasource.network.TruffleServiceImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule{

    @Singleton
    @Provides
    fun provideHttpClient(): HttpClient {
        return KtorClientFactory().build()
    }

    @Singleton
    @Provides
    fun provideTruffleService(
        httpClient: HttpClient,
    ): TruffleService {
        return TruffleServiceImpl(
            httpClient = httpClient,
            baseUrl = TruffleServiceImpl.BASE_URL,
        )
    }
}