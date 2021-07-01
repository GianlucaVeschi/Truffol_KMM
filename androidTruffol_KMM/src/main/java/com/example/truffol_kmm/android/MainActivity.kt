package com.example.truffol_kmm.android

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.truffol_kmm.Greeting
import android.widget.TextView
import androidx.activity.compose.setContent
import com.example.truffol_kmm.android.presentation.navigation.Navigation

fun greet(): String {
    return Greeting().greeting()
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Navigation()
        }
    }
}
