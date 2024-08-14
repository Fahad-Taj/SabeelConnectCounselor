package com.example.sabeelconnect.presentation.screens.signupscreens.SignUp

import android.util.Log
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.presentation.screens.loginscreens.LoginSignUpScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController) {

    // All of these are my state variables ---------------------------------------------------------
    val signupViewModel: SignupViewModel = viewModel()
    val response by signupViewModel.response.collectAsState()
    val context = LocalContext.current

    val my_gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFCDF8E1),
            Color(0xFFF5E0F2),
            Color(0xFFD5EBF3)
        )
    )
    // State variables over ------------------------------------------------------------------------

    // Top Column contains the Logo and Text ------------------------------------------------------
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = my_gradient)
            .padding(top = 84.dp, start = 43.dp, end = 43.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Sabeel Connect logo
        LogoAtTop()
        Spacer(modifier = Modifier.height(20.dp))

        // Create your account Text wrapped inside a box
        CreateAccountText()
        Spacer(modifier = Modifier.height(31.dp))

        InputFields(signupViewModel = signupViewModel)
        Spacer(modifier = Modifier.height(56.dp))
        // --------------------------------------------------------------------------------------------

        // SignUp button --------------------------------------------------------------------------
        SignUpButton(signupViewModel)
        Spacer(modifier = Modifier.height(71.dp))

        LaunchedEffect(response) {
            response?.let {
                Log.e("SignUp Response", it.message().toString())
                Log.e("SignUp Response", it.body().toString())
                Log.e("SignUp Response", it.errorBody()?.string().toString())
                Log.e("SignUp Response", it.code().toString())
                response?.let {
                    Toast.makeText(context, response!!.body()?.message.toString(), Toast.LENGTH_SHORT).show()
                }
                if (signupViewModel.buttonClicked.value && it.isSuccessful) {
                    navController.navigate(LoginSignUpScreen.VerificationScreen.route)
                }
            }
        }

        response?.let {
            if (signupViewModel.buttonClicked.value && !it.isSuccessful) {
                Text(text = "Invalid credentials", fontSize = 12.sp, color = Color.Red)
            } else if (signupViewModel.buttonClicked.value && it.isSuccessful) {
                Text(text = "Account created successfully!", color = Color.Blue, fontSize = 12.sp)
            }
        }
    }
}

@Preview
@Composable
fun SignUpScreenPreview(){
    SignUpScreen(navController = rememberNavController())
}