package com.example.truffol_kmm.datasource.network

import io.ktor.client.*

expect class KtorClientFactory() {
    fun build(): HttpClient
}