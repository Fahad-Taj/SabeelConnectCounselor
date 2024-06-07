package com.example.sabeelconnect.screens.bottomscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.ui.theme.PrimaryGreen
import com.example.sabeelconnect.uicomponents.TextFieldComposable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HelpScreen(navController: NavHostController){

    var userID by remember {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .height(20.dp)
                            .width(40.dp)
                            .clickable { navController.popBackStack() },
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                title = { Text("Help", fontSize = 20.sp, color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryGreen
                ) // Optional: Set elevation for the AppBar
            )
        }
    ) {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(40.dp))
            Icon(
                modifier = Modifier
                    .height(24.dp)
                    .width(91.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.sabeel_connect_green_logo_vec),
                contentDescription = null,
                tint = PrimaryGreen
            )
            Spacer(modifier = Modifier.height(30.dp))
            Text(text = "How can we help?", fontSize = 20.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(50.dp))
            TextFieldComposable(
                modifier = Modifier
                    .height(50.dp)
                    .width(238.dp)
                    .clip(RoundedCornerShape(12.dp))
                    .border(1.dp, Color(0xff8c8888), RoundedCornerShape(12.dp)),
                parameter = userID,
                placeholder = "Enter phone no. or email",
                image = R.drawable.user_profile_account_vec,
                function = {userID = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
            )
            Spacer(modifier = Modifier.height(30.dp))
            Box(
                modifier = Modifier
                    .height(37.dp)
                    .width(126.dp)
                    .clip(RoundedCornerShape(17.dp))
                    .background(
                        PrimaryGreen, RoundedCornerShape(17.dp)
                    )
                    .clickable {  },
                contentAlignment = Alignment.Center
            ){
                Text(text = "Submit", color = Color.White, fontSize = 12.sp)
            }
        }
    }
}