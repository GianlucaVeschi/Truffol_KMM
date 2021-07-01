package com.example.truffol_kmm.android.presentation.navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.Button
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.compose.navigate

@Composable
fun Navigation(){
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.TruffleList.route) {
        composable(route = Screen.TruffleList.route) { navBackStackEntry ->
            Column{
                Text("TruffleListScreen>")
                Divider()
                Button(onClick = { navController.navigate(Screen.TruffleDetail.route)}) {
                    Text("Go TruffleDetail")
                }
            }
        }
        composable(
            route = Screen.TruffleDetail.route,
        ) { navBackStackEntry ->
            Text("TruffleDetailScreen")
        }
    }
}