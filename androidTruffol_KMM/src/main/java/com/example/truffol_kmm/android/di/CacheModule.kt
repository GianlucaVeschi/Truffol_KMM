package com.example.truffol_kmm.android.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import com.example.truffol_kmm.android.BaseApplication
import com.example.truffol_kmm.datasource.cache.*
import com.example.truffol_kmm.domain.util.DatetimeUtil
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CacheModule {

    @Singleton
    @Provides
    fun provideTruffleDatabase(context: BaseApplication): TruffleDatabase {
        return TruffleDatabaseFactory(driverFactory = DriverFactory(context)).createDatabase()
    }

    @Singleton
    @Provides
    fun provideTruffleCache(
        truffleDatabase: TruffleDatabase,
    ): TruffleCache {
        return TruffleCacheImpl(
            truffleDatabase = truffleDatabase,
            datetimeUtil = DatetimeUtil(),
        )
    }
}