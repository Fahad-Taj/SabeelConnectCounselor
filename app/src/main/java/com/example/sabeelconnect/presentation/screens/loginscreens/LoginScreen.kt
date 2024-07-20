package com.example.sabeelconnect.presentation.screens.loginscreens

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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
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
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.presentation.navigation.MAIN_SCREEN_ROUTE
import com.example.sabeelconnect.presentation.screens.SIGNUP_GRAPH_ROUTE
import com.example.sabeelconnect.presentation.ui.theme.placeholder_text
import com.example.sabeelconnect.presentation.ui.theme.primary_green
import com.example.sabeelconnect.presentation.ui.theme.secondary_green
import com.example.sabeelconnect.presentation.uicomponents.TextFieldComposable

@Composable
fun LoginScreen(navController: NavHostController){

    val loginViewModel: LoginScreenViewModel = viewModel()
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    val response by loginViewModel.response.collectAsState()

    val my_gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFCDF8E1),
            Color(0xFFF5E0F2),
            Color(0xFFD5EBF3)
        )
    )

    var buttonClicked by remember {
        mutableStateOf(false)
    }

    // Main Column, it will occupy the complete space and will have our gradient
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = my_gradient)
            .padding(top = 84.dp, bottom = 0.dp, start = 43.dp, end = 43.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){

        // Logo present at the top
        Image(
            modifier = Modifier
                .width(104.dp)
                .height(25.dp),
            painter = painterResource(id = R.drawable.sabeel_connect_green_logo_vec),
            contentDescription = null
        )

        Spacer(modifier = Modifier.height(35.dp))

        // Welcome Text
        Text(
            fontFamily = FontFamily(
                Font(R.font.inter_medium)
            ),
            text = "Welcome Back!",
            fontSize = 20.sp,
        )

        Spacer(modifier = Modifier.height(67.dp))

        // Name TextField
        TextFieldComposable(
            modifier = Modifier
                .fillMaxWidth()
                .height(51.dp)
                .border(1.5.dp, placeholder_text, RoundedCornerShape(17.dp))
                .background(Color(0xffEDEDED), RoundedCornerShape(17.dp)),
            parameter = name,
            placeholder = "Enter your name",
            image = R.drawable.user_leading_icon,
            function = { name = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
        )

        Spacer(modifier = Modifier.height(25.dp))

        // Password TextField
        TextFieldComposable(
            modifier = Modifier
                .fillMaxWidth()
                .height(51.dp)
                .border(1.5.dp, placeholder_text, RoundedCornerShape(17.dp))
                .background(Color(0xffEDEDED), RoundedCornerShape(17.dp)),
            parameter = password,
            placeholder = "Enter your password",
            image = R.drawable.password_leading_icon,
            function = { password = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            trailingImage = R.drawable.chat_all_lock_vec
        )

        Spacer(modifier = Modifier.height(3.dp))

        //Forgot Password Text which is also clickable, it is wrapped inside a Row
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Forgot Password?",
                modifier = Modifier.clickable { navController.navigate("forgotPasswordScreen") },
                color = primary_green,
                fontSize = 12.sp,
                fontFamily = FontFamily(
                    Font(R.font.inter_light)
                ),
                fontWeight = FontWeight(400)
            )
        }

        Spacer(modifier = Modifier.height(21.dp))

        // Login Button
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(38.dp)
                .clip(RoundedCornerShape(27.dp)),
            onClick = {
                loginViewModel.login(name, password)
                buttonClicked = true
                      },
            colors = ButtonDefaults.buttonColors( containerColor = primary_green )
        ) {
            Text(
                text = "Log in",
                fontSize = 12.sp,
                fontWeight = FontWeight(400),
                color = Color.White,
                fontFamily = FontFamily(
                    Font(R.font.inter_medium)
                )
            )
        }

        Spacer(modifier = Modifier.height(45.dp))

        // OR Text wrapped inside a box
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

        Spacer(modifier = Modifier.height(50.dp))

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

        Spacer(modifier = Modifier.height(87.dp))

        //Create Account button

        Box(
            modifier = Modifier
                .height(38.dp)
                .width(264.dp)
                .background(secondary_green, RoundedCornerShape(27.dp))
                .border(1.dp, primary_green, RoundedCornerShape(27.dp))
                .clickable { navController.navigate(SIGNUP_GRAPH_ROUTE) },
            contentAlignment = Alignment.Center
        ){
            Text(
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                text = "Create an account",
                color = primary_green
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        response.let {
            if(response?.isSuccessful != true && buttonClicked){
                Text(text = "Invalid credentials", fontSize = 12.sp, color = Color.Red)
            } else if(response?.isSuccessful == true && buttonClicked){
                navController.navigate(MAIN_SCREEN_ROUTE)
            } else{

            }
        }

    }
}