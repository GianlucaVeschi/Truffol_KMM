package com.example.truffol_kmm.android.presentation.trufflelist

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TruffleListViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle, // don't need for this VM
) : ViewModel() {

}