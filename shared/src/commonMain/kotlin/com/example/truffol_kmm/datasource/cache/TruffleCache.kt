package com.example.truffol_kmm.datasource.cache

import com.example.truffol_kmm.domain.model.Truffle

interface TruffleCache {

    fun insert(truffle: Truffle)

    fun insert(truffles: List<Truffle>)

    fun search(query: String): List<Truffle>

    fun getAll(): List<Truffle>

    @Throws(NullPointerException::class)
    fun get(truffleId: Int): Truffle?
}