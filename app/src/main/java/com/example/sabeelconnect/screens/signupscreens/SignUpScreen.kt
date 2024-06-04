package com.example.sabeelconnect.screens.signupscreens

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
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.ui.theme.placeholder_text
import com.example.sabeelconnect.ui.theme.primary_green
import com.example.sabeelconnect.uicomponents.TextFieldComposable

@Composable
fun SignUpScreen(navController: NavHostController){
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    val my_gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFCDF8E1),
            Color(0xFFF5E0F2),
            Color(0xFFD5EBF3)
        )
    )

    // Main Column
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = my_gradient)
            .padding(top = 84.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Sabeel Connect logo
        Image(
            modifier = Modifier
                .height(25.dp)
                .width(104.dp),
            painter = painterResource(id = R.drawable.sabeel_connect_green_logo_vec),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Create your account Text wrapped inside a box

        Box(
            modifier = Modifier
                .height(30.dp)
                .width(239.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                text = "Create your Account"
            )
        }

        Spacer(modifier = Modifier.height(31.dp))

        // Name text field composable

        TextFieldComposable(
            modifier = Modifier
                .height(51.dp)
                .width(274.dp)
                .border(1.dp, placeholder_text, RoundedCornerShape(17.dp)),
            parameter = name,
            placeholder = "Enter your name",
            image = R.drawable.user_leading_icon,
            function = { name = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Email text field composable

        TextFieldComposable(
            modifier = Modifier
                .height(51.dp)
                .width(274.dp)
                .border(1.dp, placeholder_text, RoundedCornerShape(17.dp)),
            parameter = email,
            placeholder = "Enter your email",
            image = R.drawable.email_leading_icon,
            function = { email = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Phone number text field composable

        TextFieldComposable(
            modifier = Modifier
                .height(51.dp)
                .width(274.dp)
                .border(1.dp, placeholder_text, RoundedCornerShape(17.dp)),
            parameter = phoneNumber,
            placeholder = "xxxxx - xxxxx",
            image = R.drawable.phone_leading_icon,
            function = { phoneNumber = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Password text field composable

        TextFieldComposable(
            modifier = Modifier
                .height(51.dp)
                .width(274.dp)
                .border(1.dp, placeholder_text, RoundedCornerShape(17.dp)),
            parameter = password,
            placeholder = "Password",
            image = R.drawable.password_leading_icon,
            function = { password = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )

        Spacer(modifier = Modifier.height(56.dp))

        // Sign up button wrapped inside a box

        Box(
            modifier = Modifier
                .height(38.dp)
                .width(264.dp)
                .clickable { navController.navigate("verificationScreen") }
                .background(primary_green, RoundedCornerShape(27.dp)),
            contentAlignment = Alignment.Center
        ){
            Text(
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                text = "Sign up"
            )
        }

        Spacer(modifier = Modifier.height(71.dp))

        // OR text wrapped inside a box
        Box(
            modifier = Modifier
                .height(32.dp)
                .width(49.dp),
            contentAlignment = Alignment.Center
        ){
            Text(
                fontSize = 16.sp,
                color = primary_green,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                text = "OR"
            )
        }

        Spacer(modifier = Modifier.height(31.dp))

        //Row containing the buttons of Google and Facebook Login options

        Row(
            modifier = Modifier
                .height(51.dp)
                .width(148.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Two Clickable Boxes containing images
            Box(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(10.dp))
                    .height(50.dp)
                    .width(50.dp)
                    .border(1.dp, primary_green, RoundedCornerShape(10.dp))
                    .clickable { },
                contentAlignment = Alignment.Center,
            )
            {
                Image(modifier = Modifier.size(30.dp), painter = painterResource(id = R.drawable.facebook_login), contentDescription = null)
            }

            Box(
                modifier = Modifier
                    .background(Color.White, RoundedCornerShape(10.dp))
                    .height(50.dp)
                    .width(50.dp)
                    .border(1.dp, primary_green, RoundedCornerShape(10.dp))
                    .clickable { },
                contentAlignment = Alignment.Center
            ){
                Image(modifier = Modifier.size(30.dp), painter = painterResource(id = R.drawable.google_login), contentDescription = null)
            }
        }

        // Row containing login options end here

    }

}