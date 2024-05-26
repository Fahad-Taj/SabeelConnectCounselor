package com.example.sabeelconnect.screens.topscreens

import androidx.annotation.DrawableRes
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
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
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.screens.ChatScreen

@Composable
fun AllScreen(chatNavController: NavHostController){

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 18.dp, start = 24.dp, end = 31.dp)
    ) {
        item { ArchiveBox() }
        item { Spacer(modifier = Modifier.height(21.dp)) }
        all_screen_element.all_all_screen_elements.forEach{contact_obj ->
            item { AddAllMainBoxItem(contact_obj) }
            item { Spacer(modifier = Modifier.height(13.dp)) }
        }
        item { Spacer(modifier = Modifier.height(100.dp)) }
        item { Row(
            modifier = Modifier
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.Center
        ) {
            Icon(
                modifier = Modifier
                    .height(9.dp)
                    .width(13.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.chat_all_lock_vec), 
                contentDescription = null
            )
            Spacer(modifier = Modifier.width(5.dp))
            val annotatedString = buildAnnotatedString {
                withStyle(style = SpanStyle(fontSize = 10.sp)){
                    append("Your personal message are ")
                }
                withStyle(style = SpanStyle(color = Color(0xff4caf50), fontSize = 10.sp)) {
                    append("end-to-end encrypted")
                }
            }
            Text(text = annotatedString)
        } }
    }

}

@Composable
fun AddAllMainBoxItem(contact_obj: all_screen_element){
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
            Box(modifier = Modifier.size(55.dp)){
                Image(modifier = Modifier.size(55.dp), painter = painterResource(id = contact_obj.icon), contentDescription = null)
            }
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
                Spacer(modifier = Modifier.height(7.5.dp))
                Row {
                    if(contact_obj.unreadMessages > 0){
                        Box(
                            modifier = Modifier
                                .size(10.dp)
                                .background(Color(0xff4caf50), shape = CircleShape),
                            contentAlignment = Alignment.Center
                        ){
                            Text(text = contact_obj.unreadMessages.toString(), color = Color.White, fontSize = 6.sp)
                        }
                    }
                    if(contact_obj.pinned && contact_obj.unreadMessages > 0){
                        Spacer(modifier = Modifier.width(5.dp))
                    }
                    if(contact_obj.pinned == true){
                        Icon(
                            modifier = Modifier
                                .height(12.dp)
                                .width(8.dp),
                            imageVector = ImageVector.vectorResource(id = R.drawable.chat_all_pinned_vec),
                            contentDescription = null
                        )
                    }
                }
            }
        }
    }
}

@Composable
fun ArchiveBox(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 11.dp)
            .height(22.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier.size(19.dp),
            imageVector = ImageVector.vectorResource(
            id = R.drawable.chat_all_archive_vec), 
            contentDescription = null, 
            tint = Color.Black
        )
        
        Spacer(modifier = Modifier.width(5.dp))
        Text(text = "Archived", color = Color.Black, fontSize = 13.sp)
    }
}

sealed class all_screen_element(
    @DrawableRes val icon: Int,
    val unseenStory: Boolean,
    val contact_name: String,
    val last_message: String,
    val date: String,
    val pinned: Boolean,
    val unreadMessages: Int
){
    object obj1: all_screen_element(
        icon = R.drawable.chat_all_object1_img,
        unseenStory = false,
        contact_name = "XYZ Group",
        last_message = "You: Details",
        date = "4:03 pm",
        pinned = true,
        unreadMessages = 0
    )
    object obj2: all_screen_element(
        icon = R.drawable.chat_all_object2_img,
        unseenStory = true,
        contact_name = "XYz Community",
        last_message = "You: Details",
        date = "19/06/24",
        pinned = true,
        unreadMessages = 1
    )
    object obj3: all_screen_element(
        icon = R.drawable.chat_all_object3_img,
        unseenStory = false,
        contact_name = "WBC",
        last_message = "Doubt",
        date = "15/06/24",
        pinned = false,
        unreadMessages = 2
    )
    object obj4: all_screen_element(
        icon = R.drawable.chat_all_object4_img,
        unseenStory = false,
        contact_name = "WBC Group",
        last_message = "Class name?",
        date = "19/05/24",
        pinned = false,
        unreadMessages = 0
    )

    companion object{
        val all_all_screen_elements = listOf(obj1, obj2, obj3, obj4)
    }
}