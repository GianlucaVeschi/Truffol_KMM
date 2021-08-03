package com.example.truffol_kmm.usecases

import com.example.truffol_kmm.datasource.cache.TruffleCache
import com.example.truffol_kmm.datasource.network.TruffleService
import com.example.truffol_kmm.domain.model.Truffle
import com.example.truffol_kmm.domain.util.DataState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//Copy from https://github.com/GianlucaVeschi/Truffol/blob/master/app/src/main/java/com/example/truffol/interactors/truffle/SearchTrufflesUseCase.kt

class GetTruffleListUseCase(
    private val truffleService: TruffleService,
    private val truffleCache: TruffleCache
) {
    fun run(): Flow<DataState<List<Truffle>>> = flow {
        emit(DataState.loading())
        try {
            val truffles = truffleService.getTruffleList()

            // insert into cache
            truffleCache.insert(truffles)

            // query the cache
            val cacheResult = truffleCache.getAll()

            // emit List<Recipe> from cache
            emit(DataState.data<List<Truffle>>(message = null, data = cacheResult))

        } catch (e: Exception) {
           emit(DataState.error<List<Truffle>>(message = e.message?: "Unknown Error"))
        }
    }

    private fun handleError(exceptionMessage: String?, source: String): DataState<List<Truffle>> {
        return DataState.error(exceptionMessage ?: "Unknown Error")
    }
}

/*
    private val truffleDao: TruffleDao,
    private val truffleService: TruffleService,
    private val entityMapper: TruffleEntityMapper,
    private val dtoMapper: TruffleDtoMapper
) {

    fun run(): Flow<DataState<List<Truffle>>> = flow {
        //Try to get data from the cache
        val truffleListFromCache = getTrufflesListFromCache()

        //If Data is not in the cache then get it from the network and save it in the cache
        if (truffleListFromCache.data.isNullOrEmpty()) {
            val trufflesListFromNetwork: DataState<List<Truffle>> = getTrufflesListFromNetwork()
            emit(handleTruffleListFromNetwork(trufflesListFromNetwork))
        } else {
            emit(truffleListFromCache)
        }
    }

    private suspend fun getTrufflesListFromCache(): DataState<List<Truffle>> = try {
        Timber.d("Trying to get Truffles from the $CACHE...")
        val truffles = truffleDao.getAllTruffles()
        DataState(entityMapper.fromEntityList(truffles))
    } catch (exception: Exception) {
        handleError(exception.message, CACHE)
    }

    // WARNING: This will throw exception if there is no network connection
    private suspend fun getTrufflesListFromNetwork(): DataState<List<Truffle>> = try {
        Timber.d("Trying to get Truffles from the $NETWORK...")
        val response = truffleService.getTruffleList()
        response.takeIf { it.isSuccessful }?.body()?.let {
            DataState(dtoMapper.toDomainList(it))
        } ?: handleError(response.message(), NETWORK)
    } catch (exception: Exception) {
        handleError(exception.message , NETWORK)
    }

    private suspend fun handleTruffleListFromNetwork(dataFromNetwork: DataState<List<Truffle>>): DataState<List<Truffle>> =
        try {
            dataFromNetwork.data.takeIf { !it.isNullOrEmpty() }?.let {
                truffleDao.insertTruffles(entityMapper.toEntityList(it))
                dataFromNetwork
            } ?: handleError(dataFromNetwork.error, NETWORK)
        } catch (exception: Exception) {
            handleError(exception.message, NETWORK)
        }

    private fun handleError(exceptionMessage: String?, source: String): DataState<List<Truffle>> {
        Timber.d("$source retrieval failed.")
        return DataState.error(exceptionMessage ?: "Unknown Error")
    }

    companion object {
        const val NETWORK = "network"
        const val CACHE = "cache"
    }
}*/