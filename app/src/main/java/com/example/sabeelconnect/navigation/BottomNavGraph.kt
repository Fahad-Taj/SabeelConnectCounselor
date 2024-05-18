package com.example.sabeelconnect.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.screens.BOTTOM_SCREEN_NAV_GRAPH_ROUTE
import com.example.sabeelconnect.screens.BottomScreen
import com.example.sabeelconnect.screens.bottomscreens.DashboardScreen
import com.example.sabeelconnect.screens.bottomscreens.TimelineScreen
import com.example.sabeelconnect.screens.bottomscreens.UserScreen

@Composable
fun BottomNavGraph(navController: NavHostController, paddingValues: PaddingValues){
    NavHost(
        navController = navController,
        startDestination = BottomScreen.Timeline.route,
        route = BOTTOM_SCREEN_NAV_GRAPH_ROUTE
    ) {
        composable(BottomScreen.User.route){ UserScreen(navController = navController, paddingValues = paddingValues) }
        composable(BottomScreen.Dashboard.route){ DashboardScreen(paddingValues = paddingValues) }
        composable(BottomScreen.Timeline.route){ TimelineScreen(paddingValues = paddingValues) }
        composable(BottomScreen.Chats.route){ ChatsNavGraph(paddingValues = paddingValues) }
    }
}