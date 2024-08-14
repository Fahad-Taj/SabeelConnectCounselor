package com.example.sabeelconnect.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.sabeelconnect.presentation.screens.chatscreens.AllScreen
import com.example.sabeelconnect.presentation.screens.chatscreens.CHATS_NAV_GRAPH_ROUTE
import com.example.sabeelconnect.presentation.screens.chatscreens.ChatScreen
import com.example.sabeelconnect.presentation.screens.chatscreens.GroupScreen
import com.example.sabeelconnect.presentation.screens.chatscreens.RequestedScreen

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