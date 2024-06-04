package com.example.sabeelconnect.screens

val LOGIN_SIGNUP_GRAPH_ROUTE = "login_signup_graph_route"
val LOGIN_GRAPH_ROUTE = "login_graph_route"
val SIGNUP_GRAPH_ROUTE = "signup_graph_route"

sealed class LoginSignUpScreen(
    val route: String,
    val title: String
){
    object SplashScreen: LoginSignUpScreen(route = "splashScreen", title = "Splash Screen")
    object LoginScreen: LoginSignUpScreen(route = "loginScreen", title = "Login Screen")
    object ForgotPasswordScreen: LoginSignUpScreen(route = "forgotPasswordScreen", title = "Forgot Password Screen")
    object SignUpScreen: LoginSignUpScreen(route = "signUpScreen", title = "Sign Up Screen")
    object VerificationScreen: LoginSignUpScreen(route = "verificationScreen", title = "Verification Screen")
    object UserProfileScreen: LoginSignUpScreen(route = "userProfileScreen", title = "User Profile Screen")
    object CredentialsVerificationScreen: LoginSignUpScreen(route = "credentialsVerificationScreen", title = "Credentials Verification Screen")
}