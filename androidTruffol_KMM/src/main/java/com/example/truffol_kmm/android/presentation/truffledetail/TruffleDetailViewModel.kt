package com.example.truffol_kmm.android.presentation.truffledetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.truffol_kmm.datasource.network.TruffleService
import com.example.truffol_kmm.domain.model.Truffle
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TruffleDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val truffleService: TruffleService
) : ViewModel() {

    val truffle: MutableState<Truffle?> = mutableStateOf(null)

    init {
        try {
            savedStateHandle.get<Int>("truffleId")?.let { truffleId ->
                viewModelScope.launch {
                    truffle.value = truffleService.getTruffleDetail(truffleId)
                    println("KtorTest: ${truffle.value!!.truffleName}")
                }
            }
        } catch (e: Exception) {
            // will throw exception if arg is not there for whatever reason.
            // we don't need to do anything because it will already show a composable saying "Unable to get the details of this truffle..."
        }
    }
}