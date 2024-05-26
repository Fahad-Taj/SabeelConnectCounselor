package com.example.sabeelconnect.screens

import androidx.annotation.DrawableRes
import com.example.sabeelconnect.R

const val BOTTOM_SCREEN_NAV_GRAPH_ROUTE = "bottom_screen_nav_graph_route"

sealed class BottomScreen(
    val route: String,
    val title: String,
    @DrawableRes val icon: Int
){
    object User: BottomScreen(
        route = "user_route",
        title = "User",
        icon = R.drawable.user_vec_2
    )
    object Dashboard: BottomScreen(
        route = "dashboard_route",
        title = "Dashboard",
        icon = R.drawable.dashboard_vec
    )
    object Timeline: BottomScreen(
        route = "timeline_route",
        title = "Timeline",
        icon = R.drawable.timeline_vec
    )
    object Chats: BottomScreen(
        route = "chats_route",
        title = "Chats",
        icon = R.drawable.chats_vec
    )
}
