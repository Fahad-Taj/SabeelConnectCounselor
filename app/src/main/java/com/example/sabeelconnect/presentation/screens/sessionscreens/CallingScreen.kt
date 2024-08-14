package com.example.sabeelconnect.presentation.screens.sessionscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CallingScreen(navController: NavHostController){
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                modifier = Modifier.height(50.dp),
                title = { /*TODO*/ },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xff616161)
                )
            )
        },
        bottomBar = {
            Row(
                modifier = Modifier
                    .height(10.dp)
                    .fillMaxWidth()
                    .background(Color(0xff595959))
            ) {

            }
        }
    ) {
        val padding = it
        val gradient = Brush.verticalGradient(
            listOf(
                Color(0xffBFBFBF),
                Color(0xff595959)
            )
        )
        Column(
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxSize()
                .background(gradient)
                .padding(top = 83.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Icon(modifier = Modifier
                    .height(13.dp)
                    .width(9.dp),imageVector = Icons.Filled.Lock, contentDescription = null, tint = Color.White)
                Spacer(modifier = Modifier.width(10.dp))
                Text(text = "End to End encryprted", color = Color.White, fontSize = 10.sp)
            }
            Spacer(modifier = Modifier.height(20.dp))
            Image(
                modifier = Modifier.size(90.dp).clip(CircleShape).border(1.dp, Color.White, CircleShape),
                painter = painterResource(id = R.drawable.answering_call_screen_img),
                contentDescription = null,

            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(text = "Mohammad Sohail Abbas", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            
            Spacer(modifier = Modifier.height(400.dp))
        
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 100.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color(0xff32B06C), CircleShape)
                        .clickable { navController.navigate(SessionScreen.AnsweringCallScreen.route) },
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        modifier = Modifier
                            .size(27.5.dp)
                            .rotate(135f),
                        imageVector = Icons.Filled.Call,
                        contentDescription = null,
                        tint = Color.White
                    )
                }

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color(0xffF71A1A), CircleShape)
                        .clickable { navController.popBackStack() },
                    contentAlignment = Alignment.Center
                ){
                    Icon(
                        modifier = Modifier
                            .size(27.5.dp)
                            .rotate(135f),
                        imageVector = Icons.Filled.Call,
                        contentDescription = null,
                        tint = Color.White
                    )
                }
            }


        }
    }
}