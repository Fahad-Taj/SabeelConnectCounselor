package com.example.sabeelconnect.presentation.screens.chatscreens

import androidx.annotation.DrawableRes
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.presentation.screens.sessionscreens.SESSION_SCREEN_NAV_GRAPH_ROUTE

@Composable
fun RequestedScreen(rootNavController: NavHostController, chatNavController: NavHostController){
    LazyColumn(
    modifier = Modifier
        .fillMaxSize()
        .padding(start = 13.dp, top = 12.dp, end = 30.dp)
    ) {
        item { FilterBox() }
        item { Spacer(modifier = Modifier.height(9.dp)) }
        RequestedObjects.all_requested_objects.forEach{contact_object->
            item { AddRequestedMainBoxItem(rootNavController, chatNavController, contact_object) }
            item { Spacer(modifier = Modifier.height(12.dp)) }
        }
    }
}

@Composable
fun AddRequestedMainBoxItem(rootNavController: NavHostController, chatNavController: NavHostController, contact_object: RequestedObjects){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            modifier = Modifier
                .height(55.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                modifier = Modifier.size(55.dp),
                painter = painterResource(id = contact_object.icon),
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(21.dp))
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = contact_object.name, fontSize = 13.sp, color = Color(0xff353434))
                Spacer(modifier = Modifier.height(8.5.dp))
                Text(text = contact_object.label, fontSize = 11.sp, color = Color(0xff5e5e5e))
            }
        }

        Row(
            modifier = Modifier
                .height(55.dp),
            horizontalArrangement = Arrangement.End,
            verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .height(25.dp)
                        .width(76.dp)
                        .clip(RoundedCornerShape(8.dp))
                        .background(Color(0xffefefef))
                        .border(1.dp, Color(0xff7b7b7b), RoundedCornerShape(8.dp))
                        .clickable { rootNavController.navigate(SESSION_SCREEN_NAV_GRAPH_ROUTE) },
                    contentAlignment = Alignment.Center
                    ){
                    Text(text = "Requested", fontSize = 8.sp)
                }
            }
        }
}

@Composable
fun FilterBox(){
    Row(
        modifier = Modifier
            .height(27.dp)
            .width(82.dp)
            .background(Color.White, RoundedCornerShape(4.dp))
            .border(1.dp, Color(0xffa8a8a8), RoundedCornerShape(4.dp)),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceEvenly
    ) {
        Text(text = "Filter", fontSize = 12.sp)
        Icon(
            modifier = Modifier
                .height(10.dp)
                .width(9.dp),
            imageVector = ImageVector.vectorResource(id = R.drawable.chat_requested_filter_vec),
            contentDescription = null
        )
    }
}

 open class RequestedObjects(
    @DrawableRes val icon: Int,
    val name: String,
    val label: String
){
    object obj1: RequestedObjects(
        icon = R.drawable.chat_requested_object1_img,
        name = "Syed Ali",
        label = "Type"
    )
    object obj2: RequestedObjects(
        icon = R.drawable.chat_requested_object2_img,
        name = "Hussain Ahmad",
        label = "Details"
    )
    object obj3: RequestedObjects(
        icon = R.drawable.chat_requested_object3_img,
        name = "Zubair Shaikh",
        label = "Details"
    )
    companion object{
        val all_requested_objects = listOf(obj1, obj2, obj3)
    }
}