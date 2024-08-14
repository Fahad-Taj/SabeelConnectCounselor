package com.example.sabeelconnect.presentation.screens.loginscreens.SplashScreen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.presentation.ui.theme.primary_green
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavHostController){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(primary_green),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Image(modifier = Modifier.width(141.39.dp).height(34.dp), imageVector = ImageVector.vectorResource(id = R.drawable.sabeel_connect_white_logo_vec), contentDescription = null)
        LaunchedEffect(true) {
            delay(500L) // 2000 milliseconds = 2 seconds
            navController.navigate("loginScreen")
        }
    }

}