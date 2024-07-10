package com.example.sabeelconnect.presentation.screens.loginscreens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.presentation.ui.theme.placeholder_text
import com.example.sabeelconnect.presentation.ui.theme.primary_green

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ForgotPasswordScreen(navController: NavHostController){

    val my_gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFCDF8E1),
            Color(0xFFF5E0F2),
            Color(0xFFD5EBF3)
        )
    )
    var isSelected by remember { mutableStateOf(false) }
    var shouldShowPlaceholder by remember { mutableStateOf(false) }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = my_gradient)
            .padding(top = 41.dp, bottom = 0.dp, start = 26.75.dp, end = 43.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Top Row containing the back icon and the Forgot Password Text
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(39.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Box which wraps the image
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.CenterStart){

//                Image(modifier = Modifier
//                    .height(8.75.dp)
//                    .width(10.dp)
//                    .clickable { navController.navigate("loginScreen") },
//                    painter = painterResource(id = R.drawable.back_icon), contentDescription = null)
                Icon(Icons.Filled.ArrowBack, contentDescription = "Back", modifier = Modifier.height(17.dp).width(25.dp).clickable { navController.navigate("loginScreen") },)

            }
            // Box ends here
            Spacer(modifier = Modifier.width(16.25.dp))

            //Text containing Forgot Password
            Text(
                fontSize = 20.sp,
                fontFamily = FontFamily(Font(R.font.inter_bold)),
                text = "Forgot Password?"
            )
        }

        // Top Row ends here

        Spacer(modifier = Modifier.height(20.dp))

        // Main image
        Image(modifier = Modifier
            .height(132.dp)
            .width(123.dp),
            painter = painterResource(id = R.drawable.forgot_password_header_image), contentDescription = null)

        Spacer(modifier = Modifier.height(19.dp))

        // Phone number TextField with placeholder text

        TextField(
            modifier = Modifier
                .onFocusChanged {
                    isSelected = !isSelected
                    if (isSelected && phoneNumber == "") {
                        shouldShowPlaceholder = true
                    } else shouldShowPlaceholder = false
                }
                .height(48.82.dp)
                .width(237.dp)
                .background(Color.White, RoundedCornerShape(17.dp))
                .border(1.dp, placeholder_text, RoundedCornerShape(17.dp)),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            shape = RoundedCornerShape(17.dp),
            value = if (shouldShowPlaceholder) "Enter phone number" else phoneNumber,
            onValueChange = {
                phoneNumber = it
            },
            textStyle = if (shouldShowPlaceholder) {
                TextStyle(
                    fontSize = 12.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    color = placeholder_text
                )
            } else {
                TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    color = Color.Black
                )
            },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        // Main TextField ends here

        Spacer(modifier = Modifier.height(23.18.dp))

        // Submit button

        Box(
            modifier = Modifier
                .height(37.dp)
                .width(126.dp)
                .background(primary_green, RoundedCornerShape(17.dp))
                .clickable { },
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Submit",
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                color = Color.White
            )
        }

        // My name is Fahad Taj

    }
}