package com.example.truffol_kmm.android.presentation.truffledetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TruffleDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    val truffleId: MutableState<Int?> = mutableStateOf(null)

    init {
        try {
            savedStateHandle.get<Int>("truffleId")?.let { truffleId ->
                this.truffleId.value = truffleId
            }
        } catch (e: Exception) {
            // will throw exception if arg is not there for whatever reason.
            // we don't need to do anything because it will already show a composable saying "Unable to get the details of this truffle..."
        }
    }
}