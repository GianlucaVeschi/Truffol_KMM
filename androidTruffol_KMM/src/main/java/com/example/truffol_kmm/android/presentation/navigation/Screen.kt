package com.example.truffol_kmm.android.presentation.navigation

sealed class Screen(
    val route:String
) {
    object TruffleList: Screen("truffleList")

    object TruffleDetail: Screen("truffleDetail")
}