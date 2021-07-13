package com.example.truffol_kmm.android.presentation.truffledetail

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.truffol_kmm.domain.model.Truffle

@Composable
fun TruffleDetailScreen(
    truffle: Truffle?
) {
    if (truffle != null) {
        Column(modifier = Modifier.fillMaxWidth()) {
            Text("Truffle Id ${truffle.id}")
            Text("Truffle Name ${truffle.truffleName}")
        }
    } else {
        Text("Error")
    }
}

@Preview
@Composable
fun PreviewTruffleDetailScreen(){
    // TODO: 13.07.21
}