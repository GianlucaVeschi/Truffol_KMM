package com.example.truffol_kmm.datasource.cache

import com.example.truffol_kmm.domain.model.Truffle
import com.example.truffol_kmm.domain.util.DatetimeUtil
import com.example.truffolkmm.datasource.cache.TruffleDbQueries

class TruffleCacheImpl(
    private val truffleDatabase: TruffleDatabase,
    private val datetimeUtil: DatetimeUtil,
) : TruffleCache {

    private var queries: TruffleDbQueries = truffleDatabase.truffleDbQueries

    override fun insert(truffle: Truffle) {
        queries.insertTruffle(
            id = truffle.id.toLong(),
            truffleName = truffle.truffleName,
            description = truffle.description,
            image_url = truffle.image_url,
            rating = truffle.rating,
            price = truffle.price
            //date_updated = datetimeUtil.toEpochMilliseconds(truffle.dateUpdated),
            //date_added = datetimeUtil.toEpochMilliseconds(truffle.dateAdded),
        )
    }

    override fun insert(truffles: List<Truffle>) {
        for (truffle in truffles) {
            insert(truffle)
        }
    }

    override fun search(query: String): List<Truffle> {
        return queries.searchTruffles(query = query).executeAsList().toTruffleList()
    }

    override fun getAll(): List<Truffle> {
        return queries.getAllTruffles().executeAsList().toTruffleList()
    }

    override fun get(truffleId: Int): Truffle? {
        return try {
            queries.getTruffleById(truffleId.toLong())
                .executeAsOne().toTruffle()
        } catch (e: NullPointerException) {
            null
        }
    }

}