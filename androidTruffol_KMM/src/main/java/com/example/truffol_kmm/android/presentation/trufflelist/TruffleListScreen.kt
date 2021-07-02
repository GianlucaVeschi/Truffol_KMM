package com.example.truffol_kmm.android.presentation.trufflelist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun TruffleListScreen(
    onSelectTruffle: (Int) -> Unit,
) {
    LazyColumn {
        items(100){ truffleId ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clickable {
                        onSelectTruffle(truffleId)
                    }
            ){
                Text(
                    modifier = Modifier
                        .padding(16.dp),
                    text = "TruffleId = ${truffleId}"
                )
            }
        }
    }
}
