package com.example.truffol_kmm.android.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.*
import com.example.truffol_kmm.android.presentation.truffledetail.TruffleDetailScreen
import com.example.truffol_kmm.android.presentation.trufflelist.TruffleListScreen

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.TruffleList.route) {

        composable(route = Screen.TruffleList.route) { navBackStackEntry ->
            Column{
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
            TruffleDetailScreen(truffleId = navBackStackEntry.arguments?.getInt("truffleId"))
        }
    }
}