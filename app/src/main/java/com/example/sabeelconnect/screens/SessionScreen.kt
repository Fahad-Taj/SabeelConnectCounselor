package com.example.sabeelconnect.screens

import com.example.sabeelconnect.screens.bottomscreens.UserScreenItems
import com.example.sabeelconnect.screens.topscreens.RequestedObjects

const val SESSION_SCREEN_NAV_GRAPH_ROUTE = "session_screen_nav_graph_route"
const val SCREEN_OBJECT = "screen_obj"

sealed class SessionScreen(
    val route: String,
    val title: String
){
    object AcceptanceScreen: SessionScreen(route = "acceptance_screen_route", title = "Acceptance Screen")
    object AcceptedScreen: SessionScreen(route = "accepted_screen_route", title = " Accepted Screen"){}
    object CallingScreen: SessionScreen(route = "calling_screen_route", title = "Calling Screen")
    object AnsweringCallScreen: SessionScreen(route = "answering_call_screen_route", title = "Answering Call Screen")
}