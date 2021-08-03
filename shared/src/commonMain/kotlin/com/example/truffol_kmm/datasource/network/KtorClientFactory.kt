package com.example.truffol_kmm.datasource.network

import com.example.truffol_kmm.datasource.network.model.TruffleApiModel
import com.example.truffol_kmm.domain.model.Truffle
import io.ktor.client.*

fun TruffleApiModel.toTruffle(): Truffle {
    return Truffle(
        id = this.id,
        truffleName = this.tartufoName,
        description = this.description,
        image_url = this.image_url,
        rating = this.rating,
        price = this.price
    )
}

fun List<TruffleApiModel>.toTruffleList(): List<Truffle> {
    return map { it.toTruffle() }
}

expect class KtorClientFactory() {
    fun build(): HttpClient
}