package com.example.sabeelconnect.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.screens.CHATS_NAV_GRAPH_ROUTE
import com.example.sabeelconnect.screens.ChatScreen
import com.example.sabeelconnect.screens.topscreens.AllScreen
import com.example.sabeelconnect.screens.topscreens.GroupScreen
import com.example.sabeelconnect.screens.topscreens.RequestedScreen

@Composable
fun ChatsNavGraph(rootNavController: NavHostController, chatNavController: NavHostController){
    NavHost(
        navController = chatNavController,
        startDestination = ChatScreen.All.route,
        route = CHATS_NAV_GRAPH_ROUTE
    ) {
        composable(ChatScreen.All.route){ AllScreen(rootNavController = rootNavController, chatNavController = chatNavController) }
        composable(ChatScreen.Group.route){ GroupScreen(rootNavController = rootNavController, chatNavController = chatNavController) }
        composable(ChatScreen.Requested.route){ RequestedScreen(rootNavController = rootNavController, chatNavController = chatNavController) }
    }
}