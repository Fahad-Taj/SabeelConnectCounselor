package com.example.sabeelconnect.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.presentation.screens.BOTTOM_SCREEN_NAV_GRAPH_ROUTE
import com.example.sabeelconnect.presentation.screens.BottomScreen
import com.example.sabeelconnect.presentation.screens.bottomscreens.DashboardScreen
import com.example.sabeelconnect.presentation.screens.bottomscreens.HelpScreen
import com.example.sabeelconnect.presentation.screens.bottomscreens.TimelineScreen
import com.example.sabeelconnect.presentation.screens.bottomscreens.UserScreen
import com.example.sabeelconnect.presentation.screens.topscreens.ChatScaffold

@Composable
fun BottomNavGraph(rootNavController: NavHostController, navController: NavHostController, paddingValues: PaddingValues){
    NavHost(
        navController = navController,
        startDestination = com.example.sabeelconnect.presentation.screens.BottomScreen.Chats.route,
        route = com.example.sabeelconnect.presentation.screens.BOTTOM_SCREEN_NAV_GRAPH_ROUTE
    ) {
        composable(com.example.sabeelconnect.presentation.screens.BottomScreen.User.route){ UserScreen(navController = navController, paddingValues = paddingValues) }
        composable(com.example.sabeelconnect.presentation.screens.BottomScreen.Dashboard.route){ DashboardScreen(navController = navController, paddingValues = paddingValues) }
        composable(com.example.sabeelconnect.presentation.screens.BottomScreen.Timeline.route){ TimelineScreen(paddingValues = paddingValues) }
        composable(com.example.sabeelconnect.presentation.screens.BottomScreen.Chats.route){ ChatScaffold(rootNavController = rootNavController, paddingValues = paddingValues) }
        composable("help_screen_route"){ HelpScreen(navController = navController)}
    }
}