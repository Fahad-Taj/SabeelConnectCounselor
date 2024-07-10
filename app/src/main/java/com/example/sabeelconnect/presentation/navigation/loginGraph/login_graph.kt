package com.example.sabeelconnect.presentation.navigation.loginGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sabeelconnect.presentation.screens.LOGIN_GRAPH_ROUTE
import com.example.sabeelconnect.presentation.screens.LoginSignUpScreen
import com.example.sabeelconnect.presentation.screens.loginscreens.ForgotPasswordScreen
import com.example.sabeelconnect.presentation.screens.loginscreens.LoginScreen
import com.example.sabeelconnect.presentation.screens.loginscreens.SplashScreen

fun NavGraphBuilder.loginGraph(
    navController: NavHostController
){
    navigation(startDestination = com.example.sabeelconnect.presentation.screens.LoginSignUpScreen.SplashScreen.route, route = com.example.sabeelconnect.presentation.screens.LOGIN_GRAPH_ROUTE){
        composable(com.example.sabeelconnect.presentation.screens.LoginSignUpScreen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(com.example.sabeelconnect.presentation.screens.LoginSignUpScreen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(com.example.sabeelconnect.presentation.screens.LoginSignUpScreen.ForgotPasswordScreen.route){
            ForgotPasswordScreen(navController = navController)
        }
    }
}