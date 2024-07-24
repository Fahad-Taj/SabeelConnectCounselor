package com.example.sabeelconnect.presentation.screens.signupscreens

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
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.models.SignUp.SignupRequest
import com.example.sabeelconnect.presentation.screens.LoginSignUpScreen
import com.example.sabeelconnect.presentation.ui.theme.placeholder_text
import com.example.sabeelconnect.presentation.ui.theme.primary_green
import com.example.sabeelconnect.presentation.uicomponents.CountryCodeDropdown
import com.example.sabeelconnect.presentation.uicomponents.MyDropdownMenu
import com.example.sabeelconnect.presentation.uicomponents.TextFieldComposable
import com.example.sabeelconnect.presentation.uicomponents.countryData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SignUpScreen(navController: NavHostController) {

    // All of these are my state variables ---------------------------------------------------------
    var name by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
//    var selectedText by remember {
//        mutableStateOf(Pair("Afghanistan", Pair("+93", R.drawable.flag_afghanistan)))
//    }
    val context = LocalContext.current
    val signupViewModel: SignupViewModel = viewModel()
    val response by signupViewModel.response.collectAsState()
    var buttonClicked by remember { mutableStateOf(false) }

    var countryCode by remember{ mutableStateOf("") }
    var isSelected = remember { mutableStateOf(false) }
    var shouldShowPlaceholder = remember { mutableStateOf(true) }

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
            .padding(top = 84.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // UI components...

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
        ) {
            Text(
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_semi_bold)),
                text = "Create your Account"
            )
        }

        Spacer(modifier = Modifier.height(31.dp))
        // Top Column over -------------------------------------------------------------------------

        // Name text field composable --------------------------------------------------------------
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
        // Name text field composable ends ---------------------------------------------------------


        // Email text field composable -------------------------------------------------------------
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
        // Email text field composable ends --------------------------------------------------------

        // Row begins it will contain the country code and phone number composables --------------------
        Row(
            modifier = Modifier
                .width(274.dp)
                .height(51.dp),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            // Country Code DropDown composable ------------------------------------------------------
            // I am disabling it for now and I am hardcoding the value to be +91, later I will un comment this

//            CountryCodeDropdown(
//                modifier = Modifier
//                    .width(90.dp)
//                    .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(17.dp))
//                    .background(Color.White, RoundedCornerShape(17.dp)),
//                map = countryData,
//                function = { countryCode = it }
//            )

            // Actual phone number textfield it should occupy 184.dp width with the CountryCode dropdown
            // Currently it is set to full width i.e. 274.dp
            TextField(
                modifier = Modifier
                    .width(274.dp)
                    .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(17.dp))
                    .onFocusChanged() {
                        isSelected.value = !isSelected.value
                        if (isSelected.value && phoneNumber == "")
                            shouldShowPlaceholder.value = true
                        else shouldShowPlaceholder.value = false
                    },
                value =
                if (shouldShowPlaceholder.value)
                    "Phone number"
                else phoneNumber,
                onValueChange = { phoneNumber = it },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                leadingIcon = {
                     Icon(painter = painterResource(id = R.drawable.phone_leading_icon), contentDescription = null)
                },
                textStyle = if (shouldShowPlaceholder.value) {
                    TextStyle(
                        fontSize = 12.sp,
                        color = Color(0xff8c8888)
                    )
                } else {
                    TextStyle(
                        fontSize = 14.sp,
                        color = Color.Black
                    )
                },
                shape = RoundedCornerShape(17.dp),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))
//---------------------------------------------------------------------------------------------------------
        // Password text field composable --------------------------------------------------------------
        // Contains state variables and I have to add the funcionality of hiding and unhiding the text
        // by clicking the icon (I have to add icon as well)
        TextFieldComposable(
            modifier = Modifier
                .height(51.dp)
                .width(274.dp)
                .border(1.dp, placeholder_text, RoundedCornerShape(17.dp)),
            parameter = password,
            placeholder = "Password",
            image = R.drawable.password_leading_icon,
            function = { password = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            trailingImage = R.drawable.chat_all_lock_vec
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Confirm Password text field composable ---------------------------------------------------
        // Contains the confirm password state varible, confirm_password should be equal to password
        TextFieldComposable(
            modifier = Modifier
                .height(51.dp)
                .width(274.dp)
                .border(1.dp, placeholder_text, RoundedCornerShape(17.dp)),
            parameter = confirmPassword,
            placeholder = "Confirm Password",
            image = R.drawable.password_leading_icon,
            function = { confirmPassword = it },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            visualTransformation = PasswordVisualTransformation(),
            trailingImage = R.drawable.chat_all_lock_vec
        )

        Spacer(modifier = Modifier.height(56.dp))
        // --------------------------------------------------------------------------------------------

        // SignUp button --------------------------------------------------------------------------
        // Updates state variable buttonClicked, creates a request object and passes it to the viewmodel function.
        Box(
            modifier = Modifier
                .height(38.dp)
                .width(264.dp)
                .clickable {
                    buttonClicked = true
                    val signupreq = SignupRequest(
                        username = name,
                        email = email,
//                        mobile_number = "${countryCode}${phoneNumber}",
                        // Currently I am appending the phone number with +91 later it will be changed to the country code
                        mobile_number = "+91$phoneNumber",
                        role = "Counselor",
                        password = password,
                        confirm_password = confirmPassword,
                    )
                    signupViewModel.signup(signupreq)
                }
                .background(primary_green, RoundedCornerShape(27.dp)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                color = Color.White,
                fontSize = 12.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                text = "Sign up"
            )
        }

        Spacer(modifier = Modifier.height(71.dp))

        LaunchedEffect(response) {
            response?.let {
                Log.e("SignUp Response", it.message().toString())
                Log.e("SignUp Response", it.body().toString())
                Log.e("SignUp Response", it.errorBody()?.string().toString())
                Log.e("SignUp Response", it.code().toString())
                response?.let {
                    Toast.makeText(context, response!!.message().toString(), Toast.LENGTH_SHORT).show()
                }
                if (buttonClicked && it.isSuccessful) {
                    navController.navigate(LoginSignUpScreen.VerificationScreen.route)
                }
            }
        }

        response?.let {
            if (buttonClicked && !it.isSuccessful) {
                Text(text = "Invalid credentials", fontSize = 12.sp, color = Color.Red)
            } else if (buttonClicked && it.isSuccessful) {
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