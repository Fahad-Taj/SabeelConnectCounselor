package com.example.sabeelconnect.presentation.navigation

import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.example.sabeelconnect.presentation.screens.loginscreens.ForgotPassword.ForgotPasswordScreen
import com.example.sabeelconnect.presentation.screens.loginscreens.LOGIN_SIGNUP_GRAPH_ROUTE
import com.example.sabeelconnect.presentation.screens.loginscreens.Login.LoginScreen
import com.example.sabeelconnect.presentation.screens.loginscreens.LoginSignUpScreen
import com.example.sabeelconnect.presentation.screens.loginscreens.SplashScreen.SplashScreen
import com.example.sabeelconnect.presentation.screens.signupscreens.CounselorProfile.UserProfileScreen
import com.example.sabeelconnect.presentation.screens.signupscreens.CredentialsVerification.CredentialsVerificationScreen
import com.example.sabeelconnect.presentation.screens.signupscreens.SignUp.SignUpScreen
import com.example.sabeelconnect.presentation.screens.signupscreens.VerifyNumber.VerificationScreen

fun NavGraphBuilder.loginSignUpGraph(navController: NavHostController){
    navigation(startDestination = LoginSignUpScreen.SplashScreen.route, route = LOGIN_SIGNUP_GRAPH_ROUTE){
        composable(LoginSignUpScreen.SplashScreen.route){
            SplashScreen(navController = navController)
        }
        composable(LoginSignUpScreen.LoginScreen.route){
            LoginScreen(navController = navController)
        }
        composable(LoginSignUpScreen.ForgotPasswordScreen.route){
            ForgotPasswordScreen(navController = navController)
        }
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