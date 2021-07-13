package com.example.truffol_kmm.android.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.HiltViewModelFactory
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.truffol_kmm.android.presentation.truffledetail.TruffleDetailScreen
import com.example.truffol_kmm.android.presentation.truffledetail.TruffleDetailViewModel
import com.example.truffol_kmm.android.presentation.trufflelist.TruffleListScreen
import com.example.truffol_kmm.android.presentation.trufflelist.TruffleListViewModel

@Composable
fun Navigation() {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = Screen.TruffleList.route) {

        composable(route = Screen.TruffleList.route) { navBackStackEntry ->
            Column {
                val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
                val truffleListViewModel: TruffleListViewModel = viewModel("TruffleListViewModel", factory)
                TruffleListScreen(
                    onSelectTruffle = { truffleId ->
                        navController.navigate(Screen.TruffleDetail.route + "/$truffleId")
                    }
                )
            }
        }

        composable(
            route = Screen.TruffleDetail.route + "/{truffleId}",
            arguments = listOf(navArgument("truffleId") {
                type = NavType.IntType
            })
        ) { navBackStackEntry ->
            val factory = HiltViewModelFactory(LocalContext.current, navBackStackEntry)
            val truffleDetailViewModel: TruffleDetailViewModel = viewModel("TruffleDetailViewModel", factory)
            TruffleDetailScreen(
                truffle = truffleDetailViewModel.truffle.value
            )
        }
    }
}
