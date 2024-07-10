package com.example.sabeelconnect.presentation.screens.signupscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.presentation.uicomponents.CountryCodeDropdown
import com.example.sabeelconnect.presentation.uicomponents.MyDropdownMenu
import com.example.sabeelconnect.presentation.uicomponents.countryData

@Composable
fun UserProfileScreen(navController: NavHostController){

    val scrollState = rememberScrollState()
    var name = remember { mutableStateOf("") }
    var phone_number_user = remember { mutableStateOf("") }
    var gender = remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Option 1") }
    var religiousEducation by remember{ mutableStateOf("") }
    val options = listOf("Option 1", "Option 2")

    val my_gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFCDF8E1),
            Color(0xFFF5E0F2),
            Color(0xFFD5EBF3)
        )
    )



    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = my_gradient)
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .verticalScroll(scrollState)
    ) {
        // Top part containing Image, Username and Change profile
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(125.dp),
            //temoporary border
            //.border(1.dp, Color.Black),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Box(
                modifier = Modifier
                    .size(68.dp)
                    .clip(CircleShape)
                    .background(Color(0xff8DDC68)),
                contentAlignment = Alignment.Center
            ){
                Image(modifier = Modifier.size(28.dp), painter = painterResource(id = R.drawable.user_leading_icon), contentDescription = null,)
            }
            Spacer(
                modifier = Modifier.width(20.dp))
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.Center
            ) {
                Text(text = "Username", fontSize = 17.sp, fontWeight = FontWeight.Bold)
                Spacer(modifier = Modifier.height(10.dp))
                Text(text = "Change profile", color = Color(0xff3E70BB), textDecoration = TextDecoration.Underline)
            }
        } // Row ends here


        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)){
            Text(text = "Personal info", color = Color(0xff959595),fontSize = 12.sp, fontWeight = FontWeight.Normal)
        }
        Spacer(modifier = Modifier.height(10.dp))


        //Top Box
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(Color(0xffF9FDFA), RoundedCornerShape(10.dp))
                .border(1.dp, Color(0xffBDBDBD), RoundedCornerShape(10.dp))
                .padding(15.dp)
        ){
            // Name Row
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "Name", color = Color(0xff9E9E9E), fontSize = 12.sp, fontWeight = FontWeight.Normal)
                BasicTextField(
                    modifier = Modifier
                        .width(240.dp)
                        .height(40.dp)
                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp))
                        .padding(10.dp),
                    value = name.value,
                    onValueChange = {
                        name.value = it
                    },
                    singleLine = true
                )
            }
            Spacer(modifier = Modifier.height(15.dp))


            // Phone Row
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "Phone", color = Color(0xff9E9E9E), fontSize = 13.sp, fontWeight = FontWeight.Normal)
                Row {
                    CountryCodeDropdown(modifier = Modifier
                        .width(90.dp)
                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp)), map = countryData)
                    Spacer(modifier = Modifier.width(10.dp))
                    BasicTextField(
                        modifier = Modifier
                            .width(140.dp)
                            .height(50.dp)
                            .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp))
                            .padding(vertical = 15.dp, horizontal = 10.dp),
                        value = phone_number_user.value,
                        onValueChange = {
                            phone_number_user.value = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

            //Gender Row
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Text(text = "Gender", color = Color(0xff9E9E9E), fontSize = 13.sp, fontWeight = FontWeight.Normal)
                MyDropdownMenu(modifier = Modifier
                    .width(200.dp)
                    .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp)),
                    list = listOf("Male", "Female"))
            }

        }

        // Bottom Box
        Spacer(modifier = Modifier.height(25.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(220.dp)
                .background(Color(0xffF9FDFA), RoundedCornerShape(10.dp))
                .border(1.dp, Color(0xffBDBDBD), RoundedCornerShape(10.dp))
                .padding(15.dp)
        ){

            // Language Row
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    modifier = Modifier.width(100.dp)
                ) {
                    Text(text = "Preferred Language", color = Color(0xff9E9E9E), fontSize = 13.sp, fontWeight = FontWeight.Normal)
                }

                MyDropdownMenu(modifier = Modifier
                    .width(200.dp)
                    .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp)),
                    list = listOf("Enlgish", "Urdu", "Kashmiri", "Arabic"))
            }
            Spacer(modifier = Modifier.height(15.dp))


            // Religion Education
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    modifier = Modifier.width(100.dp)
                ){
                    Text(text = "Religious Education", color = Color(0xff9E9E9E), fontSize = 13.sp, fontWeight = FontWeight.Normal)
                }

                BasicTextField(
                    modifier = Modifier
                        .width(200.dp)
                        .height(50.dp)
                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp))
                        .padding(10.dp),
                    value = religiousEducation,
                    onValueChange = {
                        religiousEducation = it
                    },
                    singleLine = true
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            // Highest Education Row
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    modifier = Modifier.width(100.dp)
                ){
                    Text(text = "Highest Education", color = Color(0xff9E9E9E), fontSize = 13.sp, fontWeight = FontWeight.Normal)

                }
                MyDropdownMenu(modifier = Modifier
                    .width(200.dp)
                    .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp)),
                    list = listOf("10th", "12th", "Graduate", "Masters", "Doctorate", "Post-doctorate"))
            }
            Spacer(modifier = Modifier.height(15.dp))

        }
        Spacer(modifier = Modifier.height(20.dp))

        // Save and Continue Button
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier
                    .height(55.dp)
                    .width(250.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff1E844D)
                ),
                onClick = { navController.navigate("credentialsVerificationScreen") }
            ) {
                Text(text = "Save and Continue", color = Color.White,)
            }
        }

    }
}
