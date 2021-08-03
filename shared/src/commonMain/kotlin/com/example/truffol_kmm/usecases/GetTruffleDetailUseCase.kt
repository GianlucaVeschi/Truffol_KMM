package com.example.truffol_kmm.usecases

import com.example.truffol_kmm.datasource.cache.TruffleCache
import com.example.truffol_kmm.datasource.network.TruffleService
import com.example.truffol_kmm.domain.model.Truffle
import com.example.truffol_kmm.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//Copy from https://github.com/GianlucaVeschi/Truffol/blob/master/app/src/main/java/com/example/truffol/interactors/truffle/SearchTrufflesUseCase.kt

class GetTruffleDetailUseCase(
    private val truffleService: TruffleService,
    private val truffleCache: TruffleCache
) {
    fun run(
        truffleId: Int
    ): Flow<DataState<Truffle>> = flow {
        try {
            val truffle = truffleService.getTruffleDetail(truffleId)

            // insert into cache
            truffleCache.insert(truffle)

            // query the cache
            val cacheResult = truffleCache.get(truffleId)

            // emit List<Recipe> from cache
            emit(DataState.data<Truffle>(message = null, data = cacheResult))
        } catch (e: Exception) {
            emit(DataState.error<Truffle>(message = e.message?: "Unknown Error"))
        }
    }
}
