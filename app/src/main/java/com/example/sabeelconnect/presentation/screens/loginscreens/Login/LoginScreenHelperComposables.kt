package com.example.sabeelconnect.presentation.screens.loginscreens.Login

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.presentation.screens.SIGNUP_GRAPH_ROUTE
import com.example.sabeelconnect.presentation.screens.signupscreens.CounselorProfile.SabeelBasicTextStyle
import com.example.sabeelconnect.presentation.ui.theme.placeholder_text
import com.example.sabeelconnect.presentation.ui.theme.primary_green
import com.example.sabeelconnect.presentation.ui.theme.secondary_green
import com.example.sabeelconnect.presentation.uicomponents.TextFieldComposable

@Composable
fun LogoAtTop(){
    Image(
        modifier = Modifier
            .width(208.dp)
            .height(50.dp),
        painter = painterResource(id = R.drawable.sabeel_connect_green_logo_vec),
        contentDescription = null
    )
}

@Composable
fun WelcomeText(){
    Text(
        fontFamily = FontFamily(
            Font(R.font.inter_bold)
        ),
        text = "Welcome Back!",
        fontSize = 30.sp,
        style = TextStyle(
            brush = Brush.linearGradient(
                colors = listOf(Color(0xff228B22), Color(0xff556B2F))
            )
        )
    )
}

@Composable
fun InputFields(loginViewModel: LoginScreenViewModel){
    // Name TextField --------------------------------------------------------------------------
    // Contains the name state variable
    TextFieldComposable(
        modifier = Modifier
            .fillMaxWidth()
            .height(61.dp)
            .border(1.2.dp, placeholder_text, RoundedCornerShape(18.dp))
            .background(Color(0xffEDEDED), RoundedCornerShape(18.dp)),
        parameter = loginViewModel.username.value,
        placeholder = "Enter your name",
        image = R.drawable.user_leading_icon,
        function = { loginViewModel.updateState(loginViewModel.username, it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )

    Spacer(modifier = Modifier.height(25.dp))

    // Password TextField ----------------------------------------------------------------------
    // Contains the password state variable
    TextFieldComposable(
        modifier = Modifier
            .fillMaxWidth()
            .height(61.dp)
            .border(1.2.dp, placeholder_text, RoundedCornerShape(17.dp))
            .background(Color(0xffEDEDED), RoundedCornerShape(17.dp)),
        parameter = loginViewModel.password.value,
        placeholder = "Enter your password",
        image = R.drawable.password_leading_icon,
        function = { loginViewModel.updateState(loginViewModel.password, it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        trailingImage = R.drawable.chat_all_lock_vec
    )
}

@Composable
fun ForgotPassword(navController: NavHostController){
    // Forgot Password Text which is also clickable, it is wrapped inside a Row ----------------
    // This button will navigate to a different screen
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.End
    ) {
        Text(
            text = "Forgot Password?",
            modifier = Modifier.clickable { navController.navigate("forgotPasswordScreen") },
            color = primary_green,
            fontSize = 14.sp,
            fontFamily = FontFamily(
                Font(R.font.inter_medium)
            ),
            fontWeight = FontWeight.SemiBold
        )
    }
}

@Composable
fun LoginButton(
    loginViewModel: LoginScreenViewModel,
    context: Context,
    function: (Boolean) -> Unit
    ){
    val isAwaiting by loginViewModel.awaitingResponse
    var color by remember { mutableStateOf(primary_green) }
    var isClickable by remember { mutableStateOf(true) }
    if (!isAwaiting){
        color = primary_green
        isClickable = true
    } else {
        color = placeholder_text
        isClickable = false
    }
    Button(
        modifier = Modifier
            .fillMaxWidth()
            .height(48.dp)
            .clip(RoundedCornerShape(27.dp)),
        onClick = {
            if(loginViewModel.username.value != "" && loginViewModel.password.value != "" && !isAwaiting){
                loginViewModel.login(loginViewModel.username.value, loginViewModel.password.value)
               function(true)
            } else if(loginViewModel.username.value == "" && !isAwaiting){
                Toast.makeText(context, "Name cannot be empty", Toast.LENGTH_SHORT).show()
            } else if(loginViewModel.password.value == "" && !isAwaiting) Toast.makeText(context, "Password cannot be empty", Toast.LENGTH_SHORT).show()
        },
        colors = ButtonDefaults.buttonColors( containerColor = color )
    ) {
        if(!isAwaiting){
            Text(
                text = "Log in",
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                color = Color.White,
                fontFamily = FontFamily(
                    Font(R.font.inter_medium)
                )
            )
        } else {
            CircularProgressIndicator(color = Color.White)
        }

    }
}

@Composable
fun ORText(){
    Box(
        modifier = Modifier
            .height(32.dp)
            .width(49.dp),
        contentAlignment = Alignment.Center
    ){
        Text(
            fontSize = 16.sp,
            fontWeight = FontWeight.SemiBold,
            color = primary_green,
            fontFamily = FontFamily(Font(R.font.inter_medium)),
            text = "OR"
        )
    }
}

@Composable
fun OtherLoginOptions(){
    Row(
        modifier = Modifier
            .height(61.dp)
            .width(170.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        // Two Clickable Boxes containing images
        Box(
            modifier = Modifier
                .background(Color.White, RoundedCornerShape(10.dp))
                .height(60.dp)
                .width(60.dp)
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
                .height(60.dp)
                .width(60.dp)
                .border(1.dp, primary_green, RoundedCornerShape(10.dp))
                .clickable { },
            contentAlignment = Alignment.Center
        ){
            Image(modifier = Modifier.size(30.dp), painter = painterResource(id = R.drawable.google_login), contentDescription = null)
        }
    }
}

@Composable
fun CreateAccountButton(navController: NavHostController){
    Box(
        modifier = Modifier
            .height(48.dp)
            .width(264.dp)
            .background(secondary_green, RoundedCornerShape(27.dp))
            .border(1.dp, primary_green, RoundedCornerShape(27.dp))
            .clip(RoundedCornerShape(27.dp))
            .clickable { navController.navigate(SIGNUP_GRAPH_ROUTE) },
        contentAlignment = Alignment.Center
    ){
        Text(
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            fontFamily = FontFamily(Font(R.font.inter_medium)),
            text = "Create an account",
            color = primary_green
        )
    }
}