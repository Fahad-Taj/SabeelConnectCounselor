package com.example.sabeelconnect

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
import com.example.sabeelconnect.presentation.navigation.BottomNavGraph
import com.example.sabeelconnect.presentation.screens.bottomscreens.BottomScreen
import com.example.sabeelconnect.presentation.ui.theme.PrimaryGreen

@Composable
fun MainScreen(rootNavController: NavHostController){
    val navController = rememberNavController()
    Scaffold(
        modifier = Modifier.navigationBarsPadding(),
        bottomBar = { BottomBar(navController = navController) }
    ) {
        BottomNavGraph(rootNavController, navController, it)
    }
}

@Composable
fun BottomBar(navController: NavHostController){
    val screens = listOf(
        BottomScreen.User,
        BottomScreen.Dashboard,
        //BottomScreen.Timeline,
        BottomScreen.Chats
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination

    if (currentDestination != null) {
        if(currentDestination.route != screens[0].route && currentDestination.route != screens[1].route){
            BottomNavigation(modifier = Modifier
                .height(75.dp)
                .background(Color.White)
                .navigationBarsPadding(),
            ) {
                screens.forEach{ screen ->
                    AddItem(screen = screen, currentDestination = currentDestination, navController = navController)
                }
            }
        }

    }
}

@Composable
fun RowScope.AddItem(screen: BottomScreen, currentDestination: NavDestination?, navController: NavHostController){
    val isSelected = currentDestination?.hierarchy?.any { it.route == screen.route }
    currentDestination?.hierarchy?.let {
        BottomNavigationItem(
            modifier = Modifier
                .background(if (isSelected == true) PrimaryGreen else Color.White)
                .padding(10.dp),
            label = {
                Text(text = screen.title, fontSize = 9.sp, color = if(isSelected == true) Color.White else PrimaryGreen)
            },
            icon = {
                Icon(
                    modifier = Modifier.size(20.dp),
                    imageVector = ImageVector.vectorResource(id = screen.icon),
                    contentDescription = null,
                    tint = if (isSelected == true) Color.White else PrimaryGreen
                )
            },
            selected = it.any {
                it.route == screen.route
            },
            onClick = {
                navController.navigate(screen.route, builder = {
                    popUpTo(screen.route){ inclusive = true }
                })
            }
        )
    }
}