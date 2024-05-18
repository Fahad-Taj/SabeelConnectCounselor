package com.example.sabeelconnect.screens.bottomscreens

import android.media.Image
import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.ui.theme.PrimaryGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserScreen(navController: NavHostController, paddingValues: PaddingValues){
    Scaffold(
        //modifier = Modifier.padding(paddingValues),
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
                title = { Text("Profile", fontSize = 20.sp, color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = PrimaryGreen
                ) // Optional: Set elevation for the AppBar
            )
        }
    ) {
        // Main content of the screen
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(20.dp))
            Row(
                modifier = Modifier
                    .padding(start = 32.dp)
                    .width(300.dp)
                    .height(60.dp)
            ) {
                // Row starts here

                Box(
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape)
                        .background(Color.Gray)
                        .border(1.dp, Color.Black, CircleShape)
                )

                Spacer(modifier = Modifier.width(20.dp))

                Column(
                    modifier = Modifier.fillMaxHeight()
                ) {
                    Text(text = "counselor", fontSize = 14.sp)
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(text = "+91 xxxxx xxxxx", fontSize = 12.sp)
                }
                Spacer(modifier = Modifier.width(100.dp))
                Column(modifier = Modifier.fillMaxHeight(), verticalArrangement = Arrangement.Center) {
                    Icon(modifier = Modifier.size(18.dp), imageVector = ImageVector.vectorResource(id = R.drawable.profile_screen_row_vec), contentDescription = null, tint = Color(0xFF3E9F42))
                }

                // Row ends here
            }

            Spacer(modifier = Modifier.height(9.dp))
            Box(modifier = Modifier
                .fillMaxWidth()
                .height(1.dp)
                .border(0.5.dp, Color(0xFFCBCBCB)))
            Spacer(modifier = Modifier.height(27.dp))

            UserScreenItems.allUserScreenItems.forEach{userScreenItem ->  
                AddItem(userScreen = userScreenItem)
                Spacer(modifier = Modifier.height(12.dp))
            }
            
        }
    }
}

@Composable
fun AddItem(
    userScreen: UserScreenItems
){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(53.dp)
            .padding(start = 41.dp, top = 10.dp)
    ) {
        Icon(
            modifier = Modifier
                .height(userScreen.icon_height.dp)
                .width(userScreen.icon_width.dp),
            imageVector = ImageVector.vectorResource(id = userScreen.icon),
            contentDescription = null,
            tint = Color.Black
        )
        Spacer(modifier = Modifier.width((59-userScreen.icon_width).dp))
        Column(
            modifier = Modifier.fillMaxHeight()
        ) {
            Text(text = userScreen.title, fontSize = 15.sp, fontWeight = FontWeight(400))
            Spacer(modifier = Modifier.height(10.dp))
            Text(text = userScreen.description, fontSize = 10.sp, fontWeight = FontWeight(400))
        }
    }
}

sealed class UserScreenItems(
    @DrawableRes val icon: Int,
    val title: String,
    val description: String,
    val icon_height: Float,
    val icon_width: Float
){
    object Account: UserScreenItems(
        icon = R.drawable.user_profile_account_vec,
        title = "Account",
        description = "Profile, Privacy, app lang....",
        icon_height = 10f,
        icon_width = 19f
    )
    object Notifications: UserScreenItems(
        icon = R.drawable.user_profile_notification_vec,
        title = "Notifications",
        description = "message, group",
        icon_height = 16f,
        icon_width = 14f
    )
    object Payment: UserScreenItems(
        icon = R.drawable.user_profile_payments_vec,
        title = "Payment",
        description = "transaction",
        icon_height = 12f,
        icon_width = 19f
    )
    object Sessions: UserScreenItems(
        icon = R.drawable.user_profile_sessions_vec,
        title = "Sessions",
        description = "upcoming sessions, confirmation",
        icon_height = 19f,
        icon_width = 11.45f
    )
    object History: UserScreenItems(
        icon = R.drawable.user_profile_history_vec,
        title = "History",
        description = "chats, completed sessions",
        icon_height = 14f,
        icon_width = 14f
    )
    object Feedback: UserScreenItems(
        icon = R.drawable.user_profile_feedback_vec,
        title = "Feedback",
        description = "review",
        icon_height = 12f,
        icon_width = 13f
    )
    object Help: UserScreenItems(
        icon = R.drawable.user_profile_help_vec,
        title = "Help",
        description = "about app, contact us",
        icon_height = 13f,
        icon_width = 13f
    )

    companion object{
        val allUserScreenItems = listOf(Account, Notifications, Payment, Sessions, History, Feedback, Help)
    }

}