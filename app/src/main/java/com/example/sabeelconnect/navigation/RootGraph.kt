package com.example.sabeelconnect.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.MainScreen

val MAIN_SCREEN_ROUTE = "main_screen_route"
val ROOT_GRAPH_ROUTE = "root_graph_route"
@Composable
fun RootGraph(){
    val rootNavController = rememberNavController()
    NavHost(
        navController = rootNavController,
        startDestination = MAIN_SCREEN_ROUTE,
        route = ROOT_GRAPH_ROUTE
    ){
        composable(MAIN_SCREEN_ROUTE){ MainScreen(rootNavController) }
        SessionGraph(navController = rootNavController)
    }
}