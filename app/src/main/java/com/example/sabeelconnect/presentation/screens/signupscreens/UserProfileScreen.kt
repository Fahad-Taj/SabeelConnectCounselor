package com.example.sabeelconnect.presentation.screens.signupscreens

import android.util.Log
import android.widget.Toast
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
import androidx.compose.foundation.layout.navigationBarsPadding
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
import androidx.compose.runtime.LaunchedEffect
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.api.access_token
import com.example.sabeelconnect.models.CreateProfile.CompleteProfileRequest
import com.example.sabeelconnect.presentation.screens.LoginSignUpScreen
import com.example.sabeelconnect.presentation.uicomponents.CountryCodeDropdown
import com.example.sabeelconnect.presentation.uicomponents.MyDropdownMenu
import com.example.sabeelconnect.presentation.uicomponents.TextFieldComposable
import com.example.sabeelconnect.presentation.uicomponents.countryData

@Composable
fun UserProfileScreen(navController: NavHostController){

    // State variables -----------------------------------------------------------------------------
    // Majority of the state variables can be collapsed into a single request object, I will implement
    // it later.
    val scrollState = rememberScrollState()
    var name by remember { mutableStateOf("") }
    var phone_number_user by remember { mutableStateOf("") }
    var gender by remember { mutableStateOf("Male") }
    var expanded by remember { mutableStateOf(false) }
    var selectedOption by remember { mutableStateOf("Option 1") }
    var religiousEducation by remember{ mutableStateOf("Aalema") }
    val options = listOf("Option 1", "Option 2")
    var age by remember { mutableStateOf(18) }
    var email by remember{ mutableStateOf("") }
    var country by remember {mutableStateOf("Aruba")}
    var state by remember {mutableStateOf("Canillo")}

    var countryCode by remember { mutableStateOf("+91") }
    var prefferedLanguage by remember{ mutableStateOf("English") }
    var highestEducation by remember{ mutableStateOf("10th") }
    var specialtyAreas by remember{ mutableStateOf("General") }
    var languagesSpoken by remember{ mutableStateOf("English") }

    var buttonClicked by remember{ mutableStateOf(false) }
    val context = LocalContext.current
    val my_gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFCDF8E1),
            Color(0xFFF5E0F2),
            Color(0xFFD5EBF3)
        )
    )
    // ---------------------------------------------------------------------------------------------

    // Viewmodel variables -------------------------------------------------------------------------
    val userProfileViewModel: UserProfileViewModel = viewModel()
    val response by userProfileViewModel.response.collectAsState()

    val infoResponse by userProfileViewModel.infoResponse.collectAsState()
    // ---------------------------------------------------------------------------------------------

    // Coroutine that will bring the values of name and phone number
    // Fetch data from the backend
//    LaunchedEffect(Unit) {
//        userProfileViewModel.getCounselorInfo(token = access_token!!)
//    }

    // Update state when infoResponse is available
//    LaunchedEffect(infoResponse) {
//        infoResponse?.let {
//            if (it.isSuccessful) {
//                val userData = it.body()?.data?.user
//                name = userData?.username ?: "No name"
//                phone_number_user = userData?.mobile_number ?: "No phone number"
//                // Update other state variables as needed
//            } else {
//                // Handle error case
//                name = "Error fetching name"
//                phone_number_user = "Error fetching phone number"
//            }
//        }
//    }


    // Column which will contain the entire composable UI screen -----------------------------------
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = my_gradient)
            .padding(horizontal = 20.dp, vertical = 10.dp)
            .verticalScroll(scrollState)
            .navigationBarsPadding()
    ) {
        // Top Row part containing Image, Username and Change profile ----------------------------------
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
        } // Row ends here -----------------------------------------------------------------------------


        Spacer(modifier = Modifier.height(10.dp))
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 30.dp)){
            Text(text = "Personal info", color = Color(0xff959595),fontSize = 12.sp, fontWeight = FontWeight.Normal)
        }
        Spacer(modifier = Modifier.height(10.dp))


        //Top Box -----------------------------------------------------------------------------------
        Column(
            modifier = Modifier
                .fillMaxWidth()
//                .height(220.dp)
                .background(Color(0xffF9FDFA), RoundedCornerShape(10.dp))
                .border(1.dp, Color(0xffBDBDBD), RoundedCornerShape(10.dp))
                .padding(15.dp)
        ){
            // Name Row-----------------------------------------------------------------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(text = "Name", color = Color(0xff9E9E9E), fontSize = 12.sp, fontWeight = FontWeight.Normal)
                // Name text field, name state variable present here -------------------------------
                BasicTextField(
                    modifier = Modifier
                        .width(240.dp)
                        .height(40.dp)
                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp))
                        .padding(10.dp),
                    value = name,
                    onValueChange = {
                        // name = it
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
                    // Country Code DropDown, it is currently disabled. I will enable it later --------------
//                    CountryCodeDropdown(
//                        function = { countryCode = it },
//                        modifier = Modifier
//                            .width(90.dp)
//                            .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp)),
//                        map = countryData
//                    )
//                    Spacer(modifier = Modifier.width(10.dp))
////                    CountryCodeDropdown(modifier = Modifier
////                        .width(90.dp)
////                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp)), map = countryData)
////                    Spacer(modifier = Modifier.width(10.dp))

                    // Contains the actual phone number, it should occupy only 140.dp width ---------
                    // Currently it is set to fillMaxWidth()
                    BasicTextField(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp)
                            .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp))
                            .padding(vertical = 15.dp, horizontal = 10.dp),
                        value = phone_number_user,
                        onValueChange = {
                            //phone_number_user = it
                        },
                        singleLine = true,
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)

                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))

            // Email Row --------------------------------------------------------------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Email", color = Color(0xff9E9E9E), fontSize = 12.sp, fontWeight = FontWeight.Normal)
                BasicTextField(
                    modifier = Modifier
                        .width(240.dp)
                        .height(40.dp)
                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp))
                        .padding(10.dp),
                    value = email,
                    onValueChange = {
                        email = it
                    },
                    singleLine = true
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            // ---------------------------------------------------------------------------------------
            //Gender and Age Row -------------------------------------------------------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ){
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Gender", color = Color(0xff9E9E9E), fontSize = 13.sp, fontWeight = FontWeight.Normal)
                    Spacer(modifier = Modifier.width(30.dp))
                    MyDropdownMenu(
                        function = { gender = it },
                        modifier = Modifier
                            .width(100.dp)
                            .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp)),
                        list = listOf("Male", "Female"))
                }
                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(text = "Age", color = Color(0xff9E9E9E), fontSize = 13.sp, fontWeight = FontWeight.Normal)
                    Spacer(modifier = Modifier.width(10.dp))
                    BasicTextField(
                        modifier = Modifier
                            .width(100.dp)
                            .height(50.dp)
                            .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp))
                            .padding(15.dp),
                        value = if(age != 0) age.toString() else "",
                        onValueChange = {
                            val inputAge = it.toIntOrNull() ?: 0
                            age = if (it.isNotEmpty()) inputAge else 0
                        },
                        singleLine = true
                    )
                }
            }
            Spacer(modifier = Modifier.height(15.dp))
            // -------------------------------------------------------------------------------------
            // Country ---------------------------------------------------------------------------
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "Country", color = Color(0xff9E9E9E), fontSize = 13.sp, fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.width(40.dp))
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp))
                        .padding(15.dp),
                    value = country,
                    onValueChange = { country = it },
                    singleLine = true
                )
            }
            Spacer(modifier = Modifier.height(15.dp))

            // State -------------------------------------------------------------------------------
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(text = "State", color = Color(0xff9E9E9E), fontSize = 13.sp, fontWeight = FontWeight.Normal)
                Spacer(modifier = Modifier.width(55.dp))
                BasicTextField(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp)
                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp))
                        .padding(15.dp),
                    value = state,
                    onValueChange = {
                        state = it
                    },
                    singleLine = true
                )
            }
        }
        // -----------------------------------------------------------------------------------------
        // Bottom Box
        Spacer(modifier = Modifier.height(25.dp))
        Column(
            modifier = Modifier
                .fillMaxWidth()
//                .height(220.dp)
                .background(Color(0xffF9FDFA), RoundedCornerShape(10.dp))
                .border(1.dp, Color(0xffBDBDBD), RoundedCornerShape(10.dp))
                .padding(15.dp)
        ){

            //Preferred Language Row --------------------------------------------------------------
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

                MyDropdownMenu(
                    function = { prefferedLanguage = it },
                    modifier = Modifier
                        .width(200.dp)
                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp)),
                    list = listOf("English", "Urdu", "Kashmiri", "Arabic"))
            }
            Spacer(modifier = Modifier.height(15.dp))


            // Religion Education ------------------------------------------------------------------
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

            // Highest Education Row ---------------------------------------------------------------
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
                MyDropdownMenu(
                    function = { highestEducation = it },
                    modifier = Modifier
                        .width(200.dp)
                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp)),
                    list = listOf("10th", "12th", "Graduate", "Masters", "PhD", "Post-doctorate"))
            }
            Spacer(modifier = Modifier.height(15.dp))

            // Specialty Areas Row -----------------------------------------------------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    modifier = Modifier.width(100.dp)
                ){
                    Text(text = "Specialty Areas", color = Color(0xff9E9E9E), fontSize = 13.sp, fontWeight = FontWeight.Normal)
                }
                MyDropdownMenu(
                    function = {specialtyAreas = it},
                    modifier = Modifier
                        .width(200.dp)
                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp)),
                    list = listOf("General", "Marriage", "Business", "Career and Lifestyle", "Hajj and Umrah", "Health and Fitness"))
            }
            Spacer(modifier = Modifier.height(15.dp))

            // Languages Spoken Row ----------------------------------------------------------------
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){
                Column(
                    modifier = Modifier.width(100.dp)
                ){
                    Text(text = "Languages Spoken", color = Color(0xff9E9E9E), fontSize = 13.sp, fontWeight = FontWeight.Normal)

                }
                MyDropdownMenu(
                    function = { languagesSpoken = it },
                    modifier = Modifier
                        .width(200.dp)
                        .border(1.dp, Color(0xff9E9E9E), RoundedCornerShape(9.dp)),
                    list = listOf("English, Arabic, Urdu, Kashmiri", "English, Arabic, Urdu", "English, Urdu", "English, Kashmiri", "Kashmiri, Urdu", "English"))
            }
            Spacer(modifier = Modifier.height(15.dp))

        }
        Spacer(modifier = Modifier.height(20.dp))

        // Save and Continue Button ----------------------------------------------------------------
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier
                    .height(55.dp)
                    .width(250.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff1E844D)
                ),
                onClick = {
                    buttonClicked = true
                    userProfileViewModel.create_profile(
                        CompleteProfileRequest(
                            academic_education = highestEducation,
                            age = age,
                            country = country,
                            state = state,
                            gender = gender,
                            languages_spoken = languagesSpoken,
                            name = name,
                            preferred_language = prefferedLanguage,
                            religion = "Islam",
                            specialty_areas = specialtyAreas,
                            religious_education = religiousEducation,
                            email = email
                        )
                    )

                }
            ) {
                Text(text = "Save and Continue", color = Color.White,)
            }
        }
    }

    LaunchedEffect(response) {
        response?.let {
            Log.e("SignUp Response", it.message().toString())
            Log.e("SignUp Response", it.body().toString())
            Log.e("SignUp Response", it.errorBody()?.string().toString())
            Log.e("SignUp Response", it.code().toString())

            Toast.makeText(context, response!!.message().toString(), Toast.LENGTH_SHORT).show()

            if (buttonClicked && it.isSuccessful) {
                navController.navigate(LoginSignUpScreen.CredentialsVerificationScreen.route)
            }
        }
    }

}

@Preview
@Composable
fun UserProfileScreenPreview(){
    UserProfileScreen(navController = rememberNavController())
}