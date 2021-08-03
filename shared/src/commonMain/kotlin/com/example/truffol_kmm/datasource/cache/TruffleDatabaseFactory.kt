package com.example.truffol_kmm.datasource.cache

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