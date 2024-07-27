package com.example.sabeelconnect.presentation.screens.signupscreens.SignUp

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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sabeelconnect.R
import com.example.sabeelconnect.models.SignUp.SignupRequest
import com.example.sabeelconnect.presentation.screens.signupscreens.CounselorProfile.SabeelBasicTextStyle
import com.example.sabeelconnect.presentation.ui.theme.placeholder_text
import com.example.sabeelconnect.presentation.ui.theme.primary_green
import com.example.sabeelconnect.presentation.uicomponents.TextFieldComposable
import kotlin.math.sign

@Composable
fun LogoAtTop(){
    Image(
        modifier = Modifier
            .height(50.dp)
            .width(208.dp),
        painter = painterResource(id = R.drawable.sabeel_connect_green_logo_vec),
        contentDescription = null
    )
}

@Composable
fun CreateAccountText(){
    Box(
        modifier = Modifier
            .height(30.dp)
            .width(239.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            fontFamily = FontFamily(
                Font(R.font.inter_bold)
            ),
            fontSize = 22.sp,
            style = TextStyle(
                brush = Brush.linearGradient(
                    colors = listOf(Color(0xff228B22), Color(0xff556B2F))
                )
            ),
            text = "Create your Account"
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun InputFields(signupViewModel: SignupViewModel){

    // These two variables are just for the phone number text field, I am going to change this later
    var isSelected = remember { mutableStateOf(false) }
    var shouldShowPlaceholder = remember { mutableStateOf(true) }

    // Name text field composable --------------------------------------------------------------
    TextFieldComposable(
        modifier = Modifier
            .height(61.dp)
            .fillMaxWidth()
            .border(1.2.dp, placeholder_text, RoundedCornerShape(18.dp))
            .background(Color(0xffEDEDED), RoundedCornerShape(18.dp)),
        parameter = signupViewModel.name.value,
        placeholder = "Enter your name",
        image = R.drawable.user_leading_icon,
        function = { signupViewModel.updateState(signupViewModel.name, it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text)
    )
    Spacer(modifier = Modifier.height(20.dp))
    // Name text field composable ends ---------------------------------------------------------


    // Email text field composable -------------------------------------------------------------
    TextFieldComposable(
        modifier = Modifier
            .height(61.dp)
            .fillMaxWidth()
            .border(1.2.dp, placeholder_text, RoundedCornerShape(18.dp))
            .background(Color(0xffEDEDED), RoundedCornerShape(18.dp)),
        parameter = signupViewModel.email.value,
        placeholder = "Enter your email",
        image = R.drawable.email_leading_icon,
        function = { signupViewModel.updateState(signupViewModel.email, it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
    )
    Spacer(modifier = Modifier.height(20.dp))
    // Email text field composable ends --------------------------------------------------------

    // Row begins it will contain the country code and phone number composables --------------------
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(61.dp),
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
                .wrapContentHeight(Alignment.CenterVertically)
                .height(61.dp)
                .fillMaxWidth()
                .border(1.2.dp, placeholder_text, RoundedCornerShape(18.dp))
                .background(Color(0xffEDEDED), RoundedCornerShape(18.dp))
                .onFocusChanged() {
                    isSelected.value = !isSelected.value
                    if (isSelected.value && signupViewModel.phoneNumber.value == "")
                        shouldShowPlaceholder.value = true
                    else shouldShowPlaceholder.value = false
                },
            value =
            if (shouldShowPlaceholder.value)
                "Phone number"
            else signupViewModel.phoneNumber.value,
            onValueChange = { signupViewModel.updateState(signupViewModel.phoneNumber, it) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            leadingIcon = {
                Icon(painter = painterResource(id = R.drawable.phone_leading_icon), contentDescription = null)
            },
            textStyle = if(shouldShowPlaceholder.value) {
                TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
                    color = Color(0xff8c8888),
                )
            } else {
                TextStyle(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.SemiBold,
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
            .height(61.dp)
            .fillMaxWidth()
            .border(1.2.dp, placeholder_text, RoundedCornerShape(18.dp))
            .background(Color(0xffEDEDED), RoundedCornerShape(18.dp)),
        parameter = signupViewModel.password.value,
        placeholder = "Password",
        image = R.drawable.password_leading_icon,
        function = { signupViewModel.updateState(signupViewModel.password, it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        trailingImage = R.drawable.chat_all_lock_vec
    )

    Spacer(modifier = Modifier.height(20.dp))

    // Confirm Password text field composable ---------------------------------------------------
    // Contains the confirm password state varible, confirm_password should be equal to password
    TextFieldComposable(
        modifier = Modifier
            .height(61.dp)
            .fillMaxWidth()
            .border(1.2.dp, placeholder_text, RoundedCornerShape(18.dp))
            .background(Color(0xffEDEDED), RoundedCornerShape(18.dp)),
        parameter = signupViewModel.confirmPassword.value,
        placeholder = "Confirm Password",
        image = R.drawable.password_leading_icon,
        function = { signupViewModel.updateState(signupViewModel.confirmPassword, it) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        visualTransformation = PasswordVisualTransformation(),
        trailingImage = R.drawable.chat_all_lock_vec
    )
}

@Composable
fun SignUpButton(signupViewModel: SignupViewModel){

    val isAwaiting by signupViewModel.awaitingResponse
    var color by remember { mutableStateOf(primary_green) }
    var isClickable by remember { mutableStateOf(true) }
    if (!isAwaiting){
        color = primary_green
        isClickable = true
    } else {
        color = placeholder_text
        isClickable = false
    }
    // Updates state variable buttonClicked, creates a request object and passes it to the viewmodel function.
    Box(
        modifier = Modifier
            .height(55.dp)
            .width(264.dp)
            .clickable(enabled = isClickable) {
                signupViewModel.buttonClicked.value = true
                signupViewModel.signup()
            }
            .background(color, RoundedCornerShape(27.dp)),
        contentAlignment = Alignment.Center
    ) {
        if(!isAwaiting){
            Text(
                color = Color.White,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                text = "Sign up",
                fontWeight = FontWeight.SemiBold
            )
        } else {
            CircularProgressIndicator(color = Color.White)
        }

    }
}