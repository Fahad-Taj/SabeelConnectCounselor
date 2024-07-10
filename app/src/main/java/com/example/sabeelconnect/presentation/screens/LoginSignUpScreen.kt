package com.example.sabeelconnect.presentation.screens

val LOGIN_SIGNUP_GRAPH_ROUTE = "login_signup_graph_route"
val LOGIN_GRAPH_ROUTE = "login_graph_route"
val SIGNUP_GRAPH_ROUTE = "signup_graph_route"

sealed class LoginSignUpScreen(
    val route: String,
    val title: String
){
    object SplashScreen: com.example.sabeelconnect.presentation.screens.LoginSignUpScreen(route = "splashScreen", title = "Splash Screen")
    object LoginScreen: com.example.sabeelconnect.presentation.screens.LoginSignUpScreen(route = "loginScreen", title = "Login Screen")
    object ForgotPasswordScreen: com.example.sabeelconnect.presentation.screens.LoginSignUpScreen(route = "forgotPasswordScreen", title = "Forgot Password Screen")
    object SignUpScreen: com.example.sabeelconnect.presentation.screens.LoginSignUpScreen(route = "signUpScreen", title = "Sign Up Screen")
    object VerificationScreen: com.example.sabeelconnect.presentation.screens.LoginSignUpScreen(route = "verificationScreen", title = "Verification Screen")
    object UserProfileScreen: com.example.sabeelconnect.presentation.screens.LoginSignUpScreen(route = "userProfileScreen", title = "User Profile Screen")
    object CredentialsVerificationScreen: com.example.sabeelconnect.presentation.screens.LoginSignUpScreen(route = "credentialsVerificationScreen", title = "Credentials Verification Screen")
}