package com.example.truffol_kmm.android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.truffol_kmm.android.presentation.navigation.Navigation
import com.example.truffol_kmm.datasource.network.KtorClientFactory
import com.example.truffol_kmm.datasource.network.TruffleServiceImpl
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

const val BASE_URL = "https://my-tartufo-api.herokuapp.com"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        CoroutineScope(IO).launch {
            val truffleService = TruffleServiceImpl(
                httpClient = KtorClientFactory().build(),
                baseUrl = BASE_URL,
            )
            val truffleId = 1
            val truffle = truffleService.getTruffleDetail(truffleId)
            println("KtorTest: ${truffle.truffleName}")
        }

        setContent {
            Navigation()
        }
    }
}
