package com.example.sabeelconnect.navigation.loginGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sabeelconnect.screens.LoginSignUpScreen
import com.example.sabeelconnect.screens.SIGNUP_GRAPH_ROUTE
import com.example.sabeelconnect.screens.signupscreens.CredentialsVerificationScreen
import com.example.sabeelconnect.screens.signupscreens.SignUpScreen
import com.example.sabeelconnect.screens.signupscreens.UserProfileScreen
import com.example.sabeelconnect.screens.signupscreens.VerificationScreen

fun NavGraphBuilder.signUpGraph(navController: NavHostController){
    navigation(startDestination = LoginSignUpScreen.SignUpScreen.route, route = SIGNUP_GRAPH_ROUTE){
        composable(LoginSignUpScreen.SignUpScreen.route){
            SignUpScreen(navController = navController)
        }
        composable(LoginSignUpScreen.VerificationScreen.route) {
            VerificationScreen(navController = navController)
        }
        composable(LoginSignUpScreen.UserProfileScreen.route){
            UserProfileScreen(navController = navController)
        }
        composable(LoginSignUpScreen.CredentialsVerificationScreen.route){
            CredentialsVerificationScreen(navController = navController)
        }
    }
}