package com.example.sabeelconnect.screens.bottomscreens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sabeelconnect.ui.theme.PrimaryGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(paddingValues: PaddingValues){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Header Title") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryGreen
                ) // Optional: Set elevation for the AppBar
            )
        }
    ) {
        // Main content of the screen
        Text(text = "Hello", modifier = Modifier.padding(it))
    }
}