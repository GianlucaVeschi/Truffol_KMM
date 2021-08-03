package com.example.truffol_kmm.datasource.cache

import com.example.truffol_kmm.domain.model.Truffle
import com.example.truffol_kmm.domain.util.DatetimeUtil
import com.example.truffolkmm.datasource.cache.Truffle_Entity
import com.squareup.sqldelight.db.SqlDriver

class TruffleDatabaseFactory(
    private val driverFactory : DriverFactory
) {
    fun createDatabase(): TruffleDatabase {
        return TruffleDatabase(driverFactory.createDriver())
    }
}

expect class DriverFactory {
    fun createDriver(): SqlDriver
}

fun Truffle_Entity.toTruffle(): Truffle {
    //val datetimeUtil = DatetimeUtil()
    return Truffle(
        id = id.toInt(),
        truffleName = truffleName,
        description = description,
        price = price,
        image_url = image_url,
        rating = rating,
        //dateAdded = datetimeUtil.toLocalDate(date_added),
        //dateUpdated = datetimeUtil.toLocalDate(date_updated),
    )
}

fun List<Truffle_Entity>.toTruffleList(): List<Truffle>{
    return map{it.toTruffle()}
}