package com.example.sabeelconnect.screens.sessionscreens

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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.screens.SessionScreen
import com.example.sabeelconnect.screens.topscreens.RequestedObjects
import com.example.sabeelconnect.ui.theme.PrimaryGreen
import org.w3c.dom.Text

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AcceptanceScreen(navController: NavHostController){
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
                title = {
                    SessionTopAppBar(navController, false)
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryGreen
                ) // Optional: Set elevation for the AppBar
            )
        },

        bottomBar = {
            Column(
                modifier = Modifier
                    .height(132.dp)
                    .fillMaxWidth()
                    .background(Color(0xfff0efef))
                    .padding(17.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(text = "Accept request from user?", fontSize = 12.sp)
                Spacer(modifier = Modifier.height(14.dp))
                Text(modifier = Modifier.align(Alignment.CenterHorizontally),text = "If you accept the request, you will be able to attend the calls and messages.", fontSize = 10.sp, color = Color(0xff777777))
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    ButtonBox(color = Color(0xfff12222), value = "Leave", func = {
                        navController.popBackStack()
                    })
                    ButtonBox(color = Color(0xfff12222), value = "Delete", func = {
                        navController.popBackStack()
                    })
                    ButtonBox(color = Color(0xff1EBA2E), value = "Accept") {
                        navController.navigate(SessionScreen.AcceptedScreen.route)
                    }
                }
            }
        }
    ) {
        LazyColumn(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .padding(horizontal = 15.dp,)
        ) {
            item { Spacer(modifier = Modifier.height(29.dp)) }
            item { Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = "Jan 12, 2024", fontSize = 11.sp)
            } }
            item { Spacer(modifier = Modifier.height(30.dp)) }
            item { SessionCard("Session detail") }
        }
    }
}

@Composable
fun SessionCard(text: String){
    Column(
        modifier = Modifier
            .height(239.dp)
            .width(194.dp)
            .clip(RoundedCornerShape(6.dp))
            .background(Color(0xffe5e5e5), RoundedCornerShape(6.dp))
            .padding(12.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(text = text, fontSize = 11.sp)
    }
}

@Composable
fun ButtonBox(color: Color, value: String, func: () -> Unit){
    Box(modifier = Modifier
        .height(30.dp)
        .width(80.dp)
        .clip(RoundedCornerShape(5.dp))
        .background(Color.White, RoundedCornerShape(5.dp))
        .border(1.dp, Color.Black, RoundedCornerShape(5.dp))
        .clickable { func() },
        contentAlignment = Alignment.Center){
        Text(text = value, color = color, fontSize = 11.sp)
    }

}

@Composable
fun SessionTopAppBar(navController: NavHostController, bool: Boolean){
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(0.7f)
        ) {
            Image(
                modifier = Modifier
                    .size(36.dp)
                    .clip(CircleShape)
                    .border(1.dp, Color.White, CircleShape),
                painter = painterResource(id = R.drawable.chat_requested_object1_img),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(7.dp))
            Column() {
                Text(text = "User", fontSize = 14.sp, color = Color.White, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(7.dp))
                Text(text = "tap here for group info", fontSize = 9.sp, color = Color.White)
            }
        }
        if(bool == true){
            Row(modifier = Modifier.padding(end = 15.dp)) {
                Icon(modifier = Modifier
                    .size(17.dp)
                    .clickable { navController.navigate(SessionScreen.CallingScreen.route) }, imageVector = Icons.Filled.Call, contentDescription = null, tint = Color.White)
            }
        } else {
            Row(modifier = Modifier.padding(end = 15.dp)) {
                DropdownMenuExample()
            }

        }
    }
}