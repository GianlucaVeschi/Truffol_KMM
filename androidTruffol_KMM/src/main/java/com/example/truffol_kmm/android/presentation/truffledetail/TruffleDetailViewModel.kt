package com.example.truffol_kmm.android.presentation.truffledetail

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.truffol_kmm.datasource.network.TruffleService
import com.example.truffol_kmm.domain.model.Truffle
import com.example.truffol_kmm.usecases.GetTruffleDetailUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TruffleDetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val getTruffleDetailUseCase: GetTruffleDetailUseCase,
) : ViewModel() {

    val truffle: MutableState<Truffle?> = mutableStateOf(null)

    init {

        savedStateHandle.get<Int>("truffleId")?.let { truffleId ->
            getTruffleDetail(truffleId = truffleId)
        }
    }

    private fun getTruffleDetail(truffleId: Int){
        getTruffleDetailUseCase.run(truffleId).onEach { dataState ->
            println("TruffleDetailVM: loading: ${dataState.isLoading}")

            dataState.data?.let { truffle ->
                println("TruffleDetailVM: truffle: ${truffle}")
                this.truffle.value = truffle
            }

            dataState.message?.let { message ->
                println("TruffleDetailVM: error: ${message}")
            }
        }.launchIn(viewModelScope)
    }
}