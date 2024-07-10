package com.example.sabeelconnect.presentation.screens.sessionscreens

import androidx.activity.ComponentActivity
import androidx.activity.SystemBarStyle
import androidx.activity.enableEdgeToEdge
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.presentation.screens.SessionScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AnsweringCallScreen(navController: NavHostController){

    val statusBarLight = Color(0xff616161)
    val statusBarDark = Color(0xff616161)
    val context = LocalContext.current as ComponentActivity
    context.enableEdgeToEdge(
        statusBarStyle = SystemBarStyle.light(
            616161,
            616161
        )
    )
    val gradientBottom = Brush.verticalGradient(
        listOf(
            Color(0xff646464),
            Color(0xff595959)
        )
    )
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
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(87.dp)
                    .background(gradientBottom)
            ) {
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(87.dp)
                        .background(
                            Color(0xff595959),
                        )
//                        .clip(
//                            shape = RoundedCornerShape(
//                                topStart = 26.dp,
//                                topEnd = 26.dp,
//                                bottomStart = 0.dp,
//                                bottomEnd = 0.dp
//                            )
//                        )
//                        .background(
//                            Color(0xff595959),
////                            RoundedCornerShape(
////                                topStart = 26.dp,
////                                topEnd = 26.dp,
////                                bottomStart = 0.dp,
////                                bottomEnd = 0.dp
////                            )
//                        )
                        .padding(horizontal = 34.dp),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Icon(
                        modifier = Modifier
                            .height(22.dp)
                            .width(26.67.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.answering_call_screen_sound_vec),
                        contentDescription = null,
                        tint = Color.White
                    )

                    Icon(
                        modifier = Modifier
                            .height(26.dp)
                            .width(19.dp),
                        imageVector = ImageVector.vectorResource(id = R.drawable.answering_call_screen_mute_vec),
                        contentDescription = null,
                        tint = Color.White
                    )

                    Box(
                        modifier = Modifier
                            .size(40.dp)
                            .clip(CircleShape)
                            .background(Color(0xffF71A1A), CircleShape)
                            .clickable { navController.navigate(com.example.sabeelconnect.presentation.screens.SessionScreen.AcceptedScreen.route) {
                                popUpTo(com.example.sabeelconnect.presentation.screens.SessionScreen.AcceptedScreen.route) {
                                    inclusive = true
                                }
                            } },
                        contentAlignment = Alignment.Center
                    ){
                        Icon(
                            modifier = Modifier
                                .size(17.5.dp)
                                .rotate(135f),
                            imageVector = Icons.Filled.Call,
                            contentDescription = null,
                            tint = Color.White
                        )
                    }

                }
            }
        }
    ) {

        val gradient = Brush.verticalGradient(
            listOf(
                Color(0xffBFBFBF),
                Color(0xff646464)
            )
        )
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(gradient)
                .padding(top = 83.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Mohammad Sohail Abbas", color = Color.White, fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Spacer(modifier = Modifier.height(33.dp))
            Image(
                modifier = Modifier.size(140.dp).clip(CircleShape).border(1.dp, Color.White, CircleShape),
                painter = painterResource(id = R.drawable.answering_call_screen_img),
                contentDescription = null
            )
            Spacer(modifier = Modifier.height(40.dp))
            Text(text = "4:45 min", color = Color.White, fontSize = 14.sp, fontWeight = FontWeight.Bold)

        }
    }
}