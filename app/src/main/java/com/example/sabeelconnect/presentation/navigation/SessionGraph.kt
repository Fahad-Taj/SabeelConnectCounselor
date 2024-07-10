package com.example.sabeelconnect.presentation.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.presentation.screens.SESSION_SCREEN_NAV_GRAPH_ROUTE
import com.example.sabeelconnect.presentation.screens.SessionScreen
import com.example.sabeelconnect.presentation.screens.sessionscreens.AcceptanceScreen
import com.example.sabeelconnect.presentation.screens.sessionscreens.AcceptedScreen
import com.example.sabeelconnect.presentation.screens.sessionscreens.AnsweringCallScreen
import com.example.sabeelconnect.presentation.screens.sessionscreens.CallingScreen


fun NavGraphBuilder.SessionGraph(
    navController: NavHostController
){
    navigation(
        startDestination = com.example.sabeelconnect.presentation.screens.SessionScreen.AcceptanceScreen.route,
        route = com.example.sabeelconnect.presentation.screens.SESSION_SCREEN_NAV_GRAPH_ROUTE
    ) {
        composable(route = com.example.sabeelconnect.presentation.screens.SessionScreen.AcceptanceScreen.route){
            AcceptanceScreen(navController = navController)
        }
        composable(route = com.example.sabeelconnect.presentation.screens.SessionScreen.AcceptedScreen.route){
            AcceptedScreen(navController = navController)
        }
        composable(route = com.example.sabeelconnect.presentation.screens.SessionScreen.CallingScreen.route){
            CallingScreen(navController = navController)
        }
        composable(route = com.example.sabeelconnect.presentation.screens.SessionScreen.AnsweringCallScreen.route){
            AnsweringCallScreen(navController = navController)
        }
    }
}