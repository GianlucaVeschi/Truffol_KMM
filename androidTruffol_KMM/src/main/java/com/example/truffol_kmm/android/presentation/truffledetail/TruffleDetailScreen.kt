package com.example.truffol_kmm.android.presentation.truffledetail

import androidx.compose.material.Text
import androidx.compose.runtime.Composable

@Composable
fun TruffleDetailScreen(
    truffleId : Int?
) {
    if(truffleId != null){
        Text("Truffle Id $truffleId")
    }
    else {
        Text("Error")
    }
}
