package com.example.truffol_kmm.android.presentation.trufflelist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.truffol_kmm.usecases.GetTruffleListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class TruffleListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle, // don't need for this VM,
    private val getTruffleListUseCase: GetTruffleListUseCase
) : ViewModel() {

    init {
        loadTruffles()
    }

    private fun loadTruffles(){
        getTruffleListUseCase.run().onEach { dataState ->
            println("TruffleListVM is loading: ${dataState.isLoading}")

            dataState.data?.let { truffles ->
                println("TruffleListVM: truffles: ${truffles}")
            }

            dataState.message?.let { message ->
                println("TruffleListVM: error: ${message}")
            }
        }.launchIn(viewModelScope)
    }
    
    companion object{
        private const val TAG = "TruffleListViewModel"
    }
}