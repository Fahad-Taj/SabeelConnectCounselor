package com.example.sabeelconnect.presentation.navigation.loginGraph

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sabeelconnect.presentation.screens.signupscreens.CredentialsVerification.CredentialsVerificationScreen
import com.example.sabeelconnect.presentation.screens.signupscreens.SignUp.SignUpScreen
import com.example.sabeelconnect.presentation.screens.signupscreens.CounselorProfile.UserProfileScreen
import com.example.sabeelconnect.presentation.screens.signupscreens.VerifyNumber.VerificationScreen

fun NavGraphBuilder.signUpGraph(navController: NavHostController){
    navigation(startDestination = com.example.sabeelconnect.presentation.screens.LoginSignUpScreen.SignUpScreen.route, route = com.example.sabeelconnect.presentation.screens.SIGNUP_GRAPH_ROUTE){
        composable(com.example.sabeelconnect.presentation.screens.LoginSignUpScreen.SignUpScreen.route){
            SignUpScreen(navController = navController)
        }
        composable(com.example.sabeelconnect.presentation.screens.LoginSignUpScreen.VerificationScreen.route) {
            VerificationScreen(navController = navController)
        }
        composable(com.example.sabeelconnect.presentation.screens.LoginSignUpScreen.UserProfileScreen.route){
            UserProfileScreen(navController = navController)
        }
        composable(com.example.sabeelconnect.presentation.screens.LoginSignUpScreen.CredentialsVerificationScreen.route){
            CredentialsVerificationScreen(navController = navController)
        }
    }
}