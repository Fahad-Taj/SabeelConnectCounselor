package com.example.sabeelconnect.navigation.loginGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sabeelconnect.screens.LOGIN_GRAPH_ROUTE
import com.example.sabeelconnect.screens.LoginSignUpScreen
import com.example.sabeelconnect.screens.loginscreens.ForgotPasswordScreen
import com.example.sabeelconnect.screens.loginscreens.LoginScreen
import com.example.sabeelconnect.screens.loginscreens.SplashScreen

fun NavGraphBuilder.loginGraph(
    navController: NavHostController
){
    navigation(startDestination = LoginSignUpScreen.SplashScreen.route, route = LOGIN_GRAPH_ROUTE){
        composable(LoginSignUpScreen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(LoginSignUpScreen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(LoginSignUpScreen.ForgotPasswordScreen.route){
            ForgotPasswordScreen(navController = navController)
        }
    }
}