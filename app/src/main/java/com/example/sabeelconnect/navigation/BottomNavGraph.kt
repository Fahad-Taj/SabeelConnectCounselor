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
import com.example.sabeelconnect.screens.bottomscreens.HelpScreen
import com.example.sabeelconnect.screens.bottomscreens.TimelineScreen
import com.example.sabeelconnect.screens.bottomscreens.UserScreen
import com.example.sabeelconnect.screens.topscreens.ChatScaffold

@Composable
fun BottomNavGraph(rootNavController: NavHostController, navController: NavHostController, paddingValues: PaddingValues){
    NavHost(
        navController = navController,
        startDestination = BottomScreen.Chats.route,
        route = BOTTOM_SCREEN_NAV_GRAPH_ROUTE
    ) {
        composable(BottomScreen.User.route){ UserScreen(navController = navController, paddingValues = paddingValues) }
        composable(BottomScreen.Dashboard.route){ DashboardScreen(navController = navController, paddingValues = paddingValues) }
        composable(BottomScreen.Timeline.route){ TimelineScreen(paddingValues = paddingValues) }
        composable(BottomScreen.Chats.route){ ChatScaffold(rootNavController = rootNavController, paddingValues = paddingValues) }
        composable("help_screen_route"){ HelpScreen(navController = navController)}
    }
}