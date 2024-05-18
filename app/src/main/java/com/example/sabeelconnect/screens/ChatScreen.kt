package com.example.sabeelconnect.screens

const val CHATS_NAV_GRAPH_ROUTE: String = "chats_nav_graph_route"

sealed class ChatScreen(
    val route: String,
    val title: String
){
    object All:ChatScreen(
        route = "all_route",
        title = "All"
    )
    object Requested:ChatScreen(
        route = "requested_route",
        title = "Requested"
    )
    object Group:ChatScreen(
        route = "group_route",
        title = "Group"
    )
}