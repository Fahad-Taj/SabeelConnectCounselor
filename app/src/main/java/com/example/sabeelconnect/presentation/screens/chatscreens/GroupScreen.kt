package com.example.sabeelconnect.presentation.screens.chatscreens

import androidx.compose.foundation.Image
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
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R

@Composable
fun Box_Image(){
    Box(modifier = Modifier.size(55.dp), contentAlignment = Alignment.Center){
        Image(modifier = Modifier.size(55.dp), painter = painterResource(id = R.drawable.chat_all_object2_img), contentDescription = null)
        Image(imageVector = ImageVector.vectorResource(id = R.drawable.chat_group_middle_vec), contentDescription = null)
    }
}

@Composable
fun GroupScreen(rootNavController: NavHostController, chatNavController: NavHostController){

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 31.dp, start = 22.dp, end = 32.dp)
    ) {
        group_screen_element.all_group_element.forEach{contact_obj ->
            item { AddGroupMainBoxItem(contact_obj) }
            item { Spacer(modifier = Modifier.height(13.dp)) }
        }
    }
}

@Composable
fun AddGroupMainBoxItem(contact_obj: group_screen_element){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(55.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth(0.8f)
                .height(55.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box_Image()
            Spacer(modifier = Modifier.width(21.dp))
            Column {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = contact_obj.contact_name, fontSize = 13.sp, color = Color(0xff353434))
                Spacer(modifier = Modifier.height(8.5.dp))
                Text(text = contact_obj.last_message, fontSize = 11.sp, color = Color(0xff5e5e5e))
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth(1f)
                .height(55.dp),
            horizontalArrangement = Arrangement.End,

            ) {
            Column(horizontalAlignment = Alignment.End) {
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = contact_obj.date, fontSize = 10.sp, color = Color(0xff5e5e5e))

            }
        }
    }
}

sealed class group_screen_element(
    val contact_name: String,
    val last_message: String,
    val date: String,
){
    object obj1: group_screen_element(
        contact_name = "Counselor's Group",
        last_message = "You: Details",
        date = "19/06/24"
    )
    object obj2: group_screen_element(
        contact_name = "Srinagar Group",
        last_message = "You: Details",
        date = "19/06/24"
    )
    object obj3: group_screen_element(
        contact_name = "NIBM Group",
        last_message = "You: Details",
        date = "19/06/24"
    )
    companion object{
        val all_group_element = listOf(obj1, obj2, obj3)
    }
}