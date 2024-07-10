package com.example.sabeelconnect.presentation.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.presentation.screens.CHATS_NAV_GRAPH_ROUTE
import com.example.sabeelconnect.presentation.screens.ChatScreen
import com.example.sabeelconnect.presentation.screens.topscreens.AllScreen
import com.example.sabeelconnect.presentation.screens.topscreens.GroupScreen
import com.example.sabeelconnect.presentation.screens.topscreens.RequestedScreen

@Composable
fun ChatsNavGraph(rootNavController: NavHostController, chatNavController: NavHostController){
    NavHost(
        navController = chatNavController,
        startDestination = com.example.sabeelconnect.presentation.screens.ChatScreen.All.route,
        route = com.example.sabeelconnect.presentation.screens.CHATS_NAV_GRAPH_ROUTE
    ) {
        composable(com.example.sabeelconnect.presentation.screens.ChatScreen.All.route){ AllScreen(rootNavController = rootNavController, chatNavController = chatNavController) }
        composable(com.example.sabeelconnect.presentation.screens.ChatScreen.Group.route){ GroupScreen(rootNavController = rootNavController, chatNavController = chatNavController) }
        composable(com.example.sabeelconnect.presentation.screens.ChatScreen.Requested.route){ RequestedScreen(rootNavController = rootNavController, chatNavController = chatNavController) }
    }
}