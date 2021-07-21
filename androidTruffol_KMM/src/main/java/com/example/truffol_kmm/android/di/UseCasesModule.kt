package com.example.truffol_kmm.android.di

import com.example.truffol_kmm.datasource.network.TruffleService
import com.example.truffol_kmm.usecases.GetTruffleDetailUseCase
import com.example.truffol_kmm.usecases.GetTruffleListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCasesModule {

    @Singleton
    @Provides
    fun provideGetTruffleListUseCase(
        truffleService: TruffleService
    ): GetTruffleListUseCase{
        return GetTruffleListUseCase(truffleService = truffleService)
    }

    @Singleton
    @Provides
    fun provideGetTruffleDetailUseCase(
        truffleService: TruffleService
    ): GetTruffleDetailUseCase {
        return GetTruffleDetailUseCase(truffleService = truffleService)
    }
}