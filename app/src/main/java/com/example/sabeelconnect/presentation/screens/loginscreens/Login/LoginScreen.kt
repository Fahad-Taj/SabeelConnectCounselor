package com.example.sabeelconnect.presentation.screens.loginscreens.Login

import android.widget.Toast
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
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


    // Viewmodel variables begins ------------------------------------------------------------------
    val loginViewModel: LoginScreenViewModel = viewModel()
    val response by loginViewModel.response.collectAsState()
    // Viewmodel variables end ---------------------------------------------------------------------
    
    val context = LocalContext.current

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
    // State variables ends ------------------------------------------------------------------------

    // Main Column, it will occupy the complete space and will have our gradient -------------------
    // Parent
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = my_gradient)
            .padding(top = 95.dp, bottom = 0.dp, start = 43.dp, end = 43.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        
        // Logo present at the top
        LogoAtTop()
        Spacer(modifier = Modifier.height(45.dp))

        // Welcome Text ----------------------------------------------------------------------------
        WelcomeText()
        Spacer(modifier = Modifier.height(70.dp))
        
        // Contains the username and password input fields ------------------------------------------
        InputFields(loginViewModel = loginViewModel)
        Spacer(modifier = Modifier.height(3.dp))
        
        // Forgot password text which is clickable, navigates to different screen ------------------
        ForgotPassword(navController = navController)
        Spacer(modifier = Modifier.height(31.dp))

        // Login Button ----------------------------------------------------------------------------
        // Clicking on this button will call the viewmodel function to hit api endpoint will our data.
        LoginButton(loginViewModel = loginViewModel, context = context, function = { buttonClicked = it })
        Spacer(modifier = Modifier.height(40.dp))

        // OR Text wrapped inside a box
        ORText()
        Spacer(modifier = Modifier.height(45.dp))
        
        // Row containing other login options
        OtherLoginOptions()
        Spacer(modifier = Modifier.height(65.dp))

        //Create Account button
        CreateAccountButton(navController = navController)
        Spacer(modifier = Modifier.height(20.dp))

        response.let {
            response?.let {
                Toast.makeText(context, response!!.message().toString(), Toast.LENGTH_SHORT).show()
            }
            if(response?.isSuccessful != true && buttonClicked){
                Text(text = "Invalid credentials", fontSize = 12.sp, color = Color.Red)
            } else if(response?.isSuccessful == true && buttonClicked){
                navController.navigate(MAIN_SCREEN_ROUTE){
                    popUpTo(com.example.sabeelconnect.presentation.screens.LoginSignUpScreen.SplashScreen.route){ inclusive = true }
                }

            } else{

            }
        }
    }
}