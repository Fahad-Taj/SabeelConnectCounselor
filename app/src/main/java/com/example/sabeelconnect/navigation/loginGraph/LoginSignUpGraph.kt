package com.example.sabeelconnect.navigation.loginGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sabeelconnect.screens.LOGIN_GRAPH_ROUTE
import com.example.sabeelconnect.screens.LOGIN_SIGNUP_GRAPH_ROUTE

fun NavGraphBuilder.loginSignUpGraph(navController: NavHostController){
    navigation(startDestination = LOGIN_GRAPH_ROUTE, route = LOGIN_SIGNUP_GRAPH_ROUTE){
        loginGraph(navController)
        signUpGraph(navController)
    }
}