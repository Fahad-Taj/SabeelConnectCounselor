package com.example.sabeelconnect.navigation

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.screens.SESSION_SCREEN_NAV_GRAPH_ROUTE
import com.example.sabeelconnect.screens.SessionScreen
import com.example.sabeelconnect.screens.sessionscreens.AcceptanceScreen
import com.example.sabeelconnect.screens.sessionscreens.AcceptedScreen
import com.example.sabeelconnect.screens.sessionscreens.AnsweringCallScreen
import com.example.sabeelconnect.screens.sessionscreens.CallingScreen
import com.example.sabeelconnect.screens.topscreens.RequestedObjects



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