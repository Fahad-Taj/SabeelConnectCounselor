package com.example.sabeelconnect.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.example.sabeelconnect.presentation.screens.sessionscreens.SESSION_SCREEN_NAV_GRAPH_ROUTE
import com.example.sabeelconnect.presentation.screens.sessionscreens.SessionScreen
import com.example.sabeelconnect.presentation.screens.sessionscreens.AcceptanceScreen
import com.example.sabeelconnect.presentation.screens.sessionscreens.AcceptedScreen
import com.example.sabeelconnect.presentation.screens.sessionscreens.AnsweringCallScreen
import com.example.sabeelconnect.presentation.screens.sessionscreens.CallingScreen


fun NavGraphBuilder.SessionGraph(
    navController: NavHostController
){
    navigation(
        startDestination = SessionScreen.AcceptanceScreen.route,
        route = SESSION_SCREEN_NAV_GRAPH_ROUTE
    ) {
        composable(route = SessionScreen.AcceptanceScreen.route){
            AcceptanceScreen(navController = navController)
        }
        composable(route = SessionScreen.AcceptedScreen.route){
            AcceptedScreen(navController = navController)
        }
        composable(route = SessionScreen.CallingScreen.route){
            CallingScreen(navController = navController)
        }
        composable(route = SessionScreen.AnsweringCallScreen.route){
            AnsweringCallScreen(navController = navController)
        }
    }
}