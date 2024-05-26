package com.example.sabeelconnect.screens.topscreens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavDestination
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.navigation.ChatsNavGraph
import com.example.sabeelconnect.screens.ChatScreen
import com.example.sabeelconnect.ui.theme.PrimaryGreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ChatScaffold(
    paddingValues: PaddingValues
){

    Scaffold(
        modifier = Modifier.padding(bottom = 75.dp),
        topBar = {
            Surface(
                elevation = 10.dp
            ) {
                TopAppBar(
                    modifier = Modifier.padding(top = 10.dp, start = 15.dp),
                    navigationIcon = {
                        Icon(
                            modifier = Modifier
                                .height(18.dp)
                                .width(73.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.sabeel_connect_green_logo_vec),
                            contentDescription = null,
                            tint = PrimaryGreen
                        )
                    },
                    title = { Text("Profile", fontSize = 20.sp, color = Color.White) },
                    colors = TopAppBarDefaults.topAppBarColors(
                        containerColor = Color.White
                    ) // Optional: Set elevation for the AppBar
                )
            }



        }
        
    ) {
        val chatNavController = rememberNavController()
        Column(
            modifier = Modifier.padding(it)
        ) {
            TopNavBar(chatNavController)
            ChatsNavGraph(chatNavController)
        }
    }
}

@Composable
fun TopNavBar(navController: NavHostController){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(46.dp)
            .padding(top = 10.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        val screens = listOf(
            ChatScreen.All,
            ChatScreen.Requested,
            ChatScreen.Group
        )

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentDestination = navBackStackEntry?.destination

        val widths = listOf(
            0.3333f,
            0.5f,
            1f
        )

        screens.forEachIndexed{index, screen ->
            TopNavElement(
                screen = screen,
                currentDestination = currentDestination,
                navController = navController,
                widths[index]

            )
        }
    }
}

@Composable
fun TopNavElement(
    screen: ChatScreen,
    currentDestination: NavDestination?,
    navController: NavHostController,
    width: Float
){
    val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route }
    val myColor = if(isSelected == true) PrimaryGreen else Color.Transparent

    Column(
        modifier = Modifier
            .fillMaxWidth(width)
            .height(36.dp),
    ) {
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(25.dp)
            .clickable {
                navController.navigate(screen.route) {
                    popUpTo(screen.route) { inclusive = true }
                }
            },
            contentAlignment = Alignment.Center,
        ){
            Text(
                text = screen.title,
                color = PrimaryGreen,
                fontSize = 12.sp
            )
        }
        Spacer(modifier = Modifier.height(7.dp))
        Box(modifier = Modifier
            .fillMaxWidth()
            .height(2.dp)
            .background(myColor)
        )


        Box(modifier = Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(PrimaryGreen))
    }

}