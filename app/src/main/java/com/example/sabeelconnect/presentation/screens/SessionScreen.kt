package com.example.sabeelconnect.presentation.screens


const val SESSION_SCREEN_NAV_GRAPH_ROUTE = "session_screen_nav_graph_route"
const val SCREEN_OBJECT = "screen_obj"

sealed class SessionScreen(
    val route: String,
    val title: String
){
    object AcceptanceScreen: com.example.sabeelconnect.presentation.screens.SessionScreen(route = "acceptance_screen_route", title = "Acceptance Screen")
    object AcceptedScreen: com.example.sabeelconnect.presentation.screens.SessionScreen(route = "accepted_screen_route", title = " Accepted Screen"){}
    object CallingScreen: com.example.sabeelconnect.presentation.screens.SessionScreen(route = "calling_screen_route", title = "Calling Screen")
    object AnsweringCallScreen: com.example.sabeelconnect.presentation.screens.SessionScreen(route = "answering_call_screen_route", title = "Answering Call Screen")
}