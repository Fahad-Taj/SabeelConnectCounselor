package com.example.sabeelconnect.presentation.screens

const val CHATS_NAV_GRAPH_ROUTE: String = "chats_nav_graph_route"

sealed class ChatScreen(
    val route: String,
    val title: String
){
    object All: com.example.sabeelconnect.presentation.screens.ChatScreen(
        route = "all_route",
        title = "All"
    )
    object Requested: com.example.sabeelconnect.presentation.screens.ChatScreen(
        route = "requested_route",
        title = "Requested"
    )
    object Group: com.example.sabeelconnect.presentation.screens.ChatScreen(
        route = "group_route",
        title = "Group"
    )
}