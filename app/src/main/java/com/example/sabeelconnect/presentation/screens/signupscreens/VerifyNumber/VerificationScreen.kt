package com.example.sabeelconnect.presentation.screens.signupscreens.VerifyNumber

import android.util.Log
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
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.presentation.screens.LoginSignUpScreen
import com.example.sabeelconnect.presentation.ui.theme.placeholder_text
import com.example.sabeelconnect.presentation.ui.theme.primary_green

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VerificationScreen(navController: NavHostController){

    val my_gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFCDF8E1),
            Color(0xFFF5E0F2),
            Color(0xFFD5EBF3)
        )
    )

    var otp by remember { mutableStateOf("") }
    val context = LocalContext.current
    val verifynumberviewmodel: VerifyNumberViewModel = viewModel()
    val response by verifynumberviewmodel.response.collectAsState()

    var buttonClicked by remember {
        mutableStateOf(false)
    }

    var focusRequesterList = listOf(
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester(),
        FocusRequester()

    )

    var otpList = remember { mutableStateListOf<String>() }
    repeat(7){
        otpList.add("")
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = my_gradient)
            .padding(top = 41.dp, bottom = 0.dp, start = 26.75.dp, end = 43.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        // Top Row containing the back icon and the Forgot Password Text
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(49.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {

            // Box which wraps the image
            Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.CenterStart){

//                Image(modifier = Modifier
//                    .height(8.75.dp)
//                    .width(10.dp)
//                    .clickable { navController.navigate("loginScreen") },
//                    painter = painterResource(id = R.drawable.back_icon), contentDescription = null)
                Icon(
                    Icons.Filled.ArrowBack, contentDescription = "Back",
                    modifier = Modifier
                        .height(19.dp)
                        .width(28.dp)
                        .clickable { navController.navigate("signUpScreen") }
                )

            }
            // Box ends here
            Spacer(modifier = Modifier.width(16.25.dp))

            //Text containing Forgot Password
            Text(
                fontSize = 22.sp,
                fontFamily = FontFamily(Font(R.font.inter_bold)),
                text = "Verification OTP"
            )
        }

        // Top Row ends here

        Spacer(modifier = Modifier.height(14.dp))

        // Column containing Text, image and OTP Boxes

        Column(
            modifier = Modifier
                .height(300.dp)
                .width(298.dp)
                .padding(top = 3.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            //Text
            Text(
                textAlign = TextAlign.Center,
                fontSize = 14.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                text = "Enter the 6-digit verification code we have sent you on phone number xxxxxxxx01"
            )

            // Image
            Image(
                modifier = Modifier
                    .height(165.dp)
                    .width(153.75.dp),
                painter = painterResource(id = R.drawable.verification_screen_header_image),
                contentDescription = null
            )

            //Row containing Focus Requester TextFields
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(64.dp)
                    .padding(horizontal = 0.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                //First OTP box
                FocusRequesterTextField(
                    focusRequester = focusRequesterList[1],
                    value = otpList[1],
                    myfunction = {
                        otpList[1] = it
                        if (otpList[1].length == 1) focusRequesterList[2].requestFocus()
                    }
                )

                // Second OTP Box
                FocusRequesterTextField(
                    focusRequester = focusRequesterList[2],
                    value = otpList[2],
                    myfunction = {
                        otpList[2] = it
                        if (otpList[2].length == 1) focusRequesterList[3].requestFocus()
                        else if (otpList[2].isEmpty()) focusRequesterList[1].requestFocus()
                    }
                )

                // Third OTP box
                FocusRequesterTextField(
                    focusRequester = focusRequesterList[3],
                    value = otpList[3],
                    myfunction = {
                        otpList[3] = it
                        if (otpList[3].length == 1) focusRequesterList[4].requestFocus()
                        else if (otpList[3].isEmpty()) focusRequesterList[2].requestFocus()
                    }
                )

                // Fourth OTP box
                FocusRequesterTextField(
                    focusRequester = focusRequesterList[4],
                    value = otpList[4],
                    myfunction = {
                        otpList[4] = it
                        if (otpList[4].length == 1) focusRequesterList[5].requestFocus()
                        else if (otpList[4].isEmpty()) focusRequesterList[3].requestFocus()
                    }
                )

                // Fifth OTP box
                FocusRequesterTextField(
                    focusRequester = focusRequesterList[5],
                    value = otpList[5],
                    myfunction = {
                        otpList[5] = it
                        if (otpList[5].length == 1) focusRequesterList[6].requestFocus()
                        else if (otpList[5].isEmpty()) focusRequesterList[4].requestFocus()
                    }
                )

                // Sixth OTP box
                FocusRequesterTextField(
                    focusRequester = focusRequesterList[6],
                    value = otpList[6],
                    myfunction = {
                        otpList[6] = it
                        if (otpList[6].isEmpty()) focusRequesterList[5].requestFocus()
                    }
                )


                // All 6 OTP boxes complete
            }

            // Row containing Focus Requester Text Fields ends here

        }

        // Column containing Text, image and OTP Boxes ends here

        Spacer(modifier = Modifier.height(6.dp))

        // Row containing Text of Resend
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 27.dp),
            horizontalArrangement = Arrangement.End
        ) {
            Text(
                text = "Resend",
                fontSize = 14.sp, color = primary_green,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                fontWeight = FontWeight.SemiBold
            )
        }

        Spacer(modifier = Modifier.height(15.dp))

        //Submit button in form of a box

        val isAwaiting by verifynumberviewmodel.awaitingResponse
        var color by remember { mutableStateOf(primary_green) }
        var isClickable by remember { mutableStateOf(true) }
        if (!isAwaiting){
            color = primary_green
            isClickable = true
        } else {
            color = placeholder_text
            isClickable = false
        }
        Box(
            modifier = Modifier
                .height(47.dp)
                .width(136.dp)
                .clip(RoundedCornerShape(19.dp))
                .background(color, RoundedCornerShape(19.dp))
                .clickable(enabled = isClickable) {
                    buttonClicked = true
                    verifynumberviewmodel.verify_number(otpList[1] + otpList[2] + otpList[3] + otpList[4] + otpList[5] + otpList[6])
                },
            contentAlignment = Alignment.Center
        ){
            if(!isAwaiting){
                Text(
                    text = "Submit",
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily(Font(R.font.inter_medium)),
                    color = Color.White
                )
            } else {
                CircularProgressIndicator(color = Color.White)
            }
        }

        // Main column ends here

        LaunchedEffect(response) {
            response?.let {
                Toast.makeText(context, response!!.body()?.message.toString(), Toast.LENGTH_SHORT).show()
                Log.e("Verification Response", it.message().toString())
                Log.e("Verification Response", it.body().toString())
                Log.e("Verification Response", it.errorBody()?.string().toString())
                Log.e("Verification Response", it.code().toString())

                if (buttonClicked && response!!.isSuccessful) {
                    navController.navigate(LoginSignUpScreen.UserProfileScreen.route)
                } else if (buttonClicked && !response!!.isSuccessful) {
                    Log.e("Response from verify number - screen - 1", "Not successful")
                }
            }
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FocusRequesterTextField(
    focusRequester: FocusRequester,
    value: String,
    myfunction: (String) -> Unit
){

    // Creating the Text Field
    TextField(
        modifier = Modifier
            .wrapContentHeight(Alignment.CenterVertically)
            .focusRequester(focusRequester)
            .width(46.dp)
            .height(64.dp)
            .border(1.dp, placeholder_text, RoundedCornerShape(12.dp)),
        value = value,
        onValueChange = {
            myfunction(it)
        },
        textStyle = TextStyle(
            fontSize = 14.sp,
            fontWeight = FontWeight.SemiBold,
            color = Color.Black
        ),
        shape = RoundedCornerShape(12.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.White,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
    )

}

@Preview
@Composable
fun VerificationPreview(){
    VerificationScreen(navController = rememberNavController())
}