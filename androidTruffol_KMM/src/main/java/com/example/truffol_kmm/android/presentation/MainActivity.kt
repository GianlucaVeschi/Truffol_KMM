package com.example.truffol_kmm.android.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.compose.setContent
import com.example.truffol_kmm.android.presentation.navigation.Navigation
import com.example.truffol_kmm.datasource.network.KtorClientFactory
import dagger.hilt.android.AndroidEntryPoint
import io.ktor.client.request.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch

const val TOKEN = "Token 9c8b06d329136da358c2d00e76946b0111ce2c48"
const val BASE_URL = "https://food2fork.ca/api/recipe"

const val TARTUFO_BASE_URL = "https://my-tartufo-api.herokuapp.com/tartufi"

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val ktorClient = KtorClientFactory().build()
        CoroutineScope(IO).launch {
            val truffleId = 2
            val truffle = ktorClient.get<String> {
                url("$TARTUFO_BASE_URL/$truffleId")
            }
            println("KtorTest: $truffle")
        }

        setContent {
            Navigation()
        }
    }
}
