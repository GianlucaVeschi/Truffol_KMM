package com.example.truffol_kmm.datasource.network

import com.example.truffol_kmm.domain.model.Truffle

interface TruffleService {

    suspend fun getTruffleList(): List<Truffle>

    suspend fun getTruffleDetail(id: Int): Truffle

}