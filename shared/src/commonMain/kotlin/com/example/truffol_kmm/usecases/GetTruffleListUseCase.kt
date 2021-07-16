package com.example.truffol_kmm.usecases

import com.example.truffol_kmm.datasource.network.TruffleService
import com.example.truffol_kmm.domain.model.Truffle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

//Copy from https://github.com/GianlucaVeschi/Truffol/blob/master/app/src/main/java/com/example/truffol/interactors/truffle/SearchTrufflesUseCase.kt

class GetTruffleListUseCase(
    private val truffleService: TruffleService
) {
    fun run(): Flow<List<Truffle>> = flow  {

        try{
            val truffles = truffleService.getTruffleList()
            emit(truffles)
        }catch (e: Exception){
            // how can we emit an error?
        }
    }
}

