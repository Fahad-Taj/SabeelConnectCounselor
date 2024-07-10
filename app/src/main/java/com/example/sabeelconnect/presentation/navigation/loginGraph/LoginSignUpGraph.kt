package com.example.sabeelconnect.presentation.navigation.loginGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sabeelconnect.presentation.screens.LOGIN_GRAPH_ROUTE
import com.example.sabeelconnect.presentation.screens.LOGIN_SIGNUP_GRAPH_ROUTE

fun NavGraphBuilder.loginSignUpGraph(navController: NavHostController){
    navigation(startDestination = com.example.sabeelconnect.presentation.screens.LOGIN_GRAPH_ROUTE, route = com.example.sabeelconnect.presentation.screens.LOGIN_SIGNUP_GRAPH_ROUTE){
        loginGraph(navController)
        signUpGraph(navController)
    }
}