package com.example.sabeelconnect.screens.bottomscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.ui.theme.PrimaryGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(navController: NavHostController, paddingValues: PaddingValues){
    Scaffold(
        modifier = Modifier.padding(),
        topBar = {
            TopAppBar(
                navigationIcon = {
                    Icon(
                        modifier = Modifier
                            .padding(start = 27.dp)
                            .height(23.dp)
                            .width(114.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.sabeel_connect_white_logo_vec),
                        contentDescription = null,
                        tint = Color.White
                    )
                },
                title = { Text("", fontSize = 20.sp, color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryGreen
                ) // Optional: Set elevation for the AppBar
            )
        }
    ) {
        Column(
            modifier = Modifier.padding(it)
        ) {
            Column(
                modifier = Modifier
                    .padding(top = 20.dp)
                    .fillMaxSize()
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(32.dp)
                        .padding(start = 22.dp),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .height(8.dp)
                            .width(15.dp)
                            .clickable { navController.popBackStack() },
                        imageVector = ImageVector.vectorResource(id = R.drawable.dashboard_top_vec), 
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(11.dp))
                    Column(
                        modifier = Modifier.fillMaxHeight()
                    ) {
                        Text(text = "Hi,", fontSize = 12.sp)
                        Text(text = "Counselor name,", fontSize = 12.sp)
                    }
                }
                Spacer(modifier = Modifier.height(22.dp))


                // Top dashboard elements row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                ) {
                    GradientCard(brush = Brush.linearGradient(colors = listOf(Color(0xffb1f499), Color(0xfff9f9f9))), "Rs 5000", "Total Amount")
                    Spacer(modifier = Modifier.width(18.dp))
                    GradientCard(brush = Brush.linearGradient(colors = listOf(Color(0xffdec2f9), Color(0xfff9f9f9))), "123", "Total Session")
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Bottom dashboard elements row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(18.dp)
                ) {
                    GradientCard(brush = Brush.linearGradient(colors = listOf(Color(0xfffcf4a9), Color(0xfff9f9f9))), "4.5", "Average Rating")
                    Spacer(modifier = Modifier.width(18.dp))
                    GradientCard(brush = Brush.linearGradient(colors = listOf(Color(0xffc2f6f9), Color(0xfff9f9f9))), "90", "Total Rating Receive")
                }
                
            }
        }
    }
}

@Composable
fun GradientCard(brush: Brush, mainText: String, secondaryText: String){
    Column(
        modifier = Modifier
            .height(100.dp)
            .width(156.dp)
            .clip(RoundedCornerShape(10.dp))
            .background(brush = brush, shape = RoundedCornerShape(10.dp))
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Spacer(modifier = Modifier.height(15.dp))
        Text(modifier = Modifier.align(Alignment.CenterHorizontally), text = mainText, fontSize = 24.sp, fontWeight = FontWeight.Bold)
        Spacer(modifier = Modifier.height(15.dp))
        Text(modifier = Modifier.align(Alignment.Start),text = secondaryText, fontSize = 10.sp)
    }
}
