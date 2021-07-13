package com.example.truffol_kmm.datasource.network

import com.example.truffol_kmm.datasource.network.model.TruffleApiModel
import com.example.truffol_kmm.domain.model.Truffle
import io.ktor.client.*
import io.ktor.client.request.*

class TruffleServiceImpl(
    private val httpClient: HttpClient,
    private val baseUrl: String, //Passed as parameter for testing purposes
) : TruffleService {

    override suspend fun getTruffleList(): List<Truffle> {
        return httpClient.get<List<TruffleApiModel>> {
            url("$baseUrl/tartufi/")
        }.toTruffleList()
    }

    override suspend fun getTruffleDetail(id: Int): Truffle {
        return httpClient.get<TruffleApiModel> {
            url("$baseUrl/tartufi/$id")
        }.toTruffle()
    }

    companion object {
        const val TARTUFO_BASE_URL = "https://my-tartufo-api.herokuapp.com"
    }
}