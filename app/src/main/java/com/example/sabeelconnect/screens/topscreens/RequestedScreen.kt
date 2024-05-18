package com.example.sabeelconnect.screens.topscreens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.example.sabeelconnect.screens.ChatScreen

@Composable
fun RequestedScreen(chatNavController: NavHostController, paddingValues: PaddingValues){
    Box(
        modifier = Modifier.padding(paddingValues).fillMaxSize(),
        contentAlignment = Alignment.Center
    ){
        Text(text = "Requested Screen", modifier = Modifier.clickable { chatNavController.navigate(
            ChatScreen.Group.route) })
    }
}