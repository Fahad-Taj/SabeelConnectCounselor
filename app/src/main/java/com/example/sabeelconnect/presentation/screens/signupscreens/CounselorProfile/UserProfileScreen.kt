package com.example.sabeelconnect.presentation.screens.signupscreens.CounselorProfile

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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.presentation.screens.loginscreens.LoginSignUpScreen
import com.example.sabeelconnect.presentation.ui.theme.placeholder_text

@Composable
fun UserProfileScreen(navController: NavHostController){
    val context = LocalContext.current
    val scrollState = rememberScrollState()
    val my_gradient = Brush.linearGradient(
        colors = listOf(
            Color(0xFFCDF8E1),
            Color(0xFFF5E0F2),
            Color(0xFFD5EBF3)
        )
    )
    val userProfileViewModel: UserProfileViewModel = viewModel()
    // This is the main composable (parent)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(my_gradient)
            .padding(top = 41.dp, bottom = 41.dp, start = 30.dp, end = 30.dp)
            .verticalScroll(scrollState),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        // Top Row which has the back button and the Display Text
        TopRow(navController = navController)
        Spacer(modifier = Modifier.height(20.dp))

        // Profile header, it has The profile pic icon and displays the username
        ProfileHeader()
        Spacer(modifier = Modifier.height(20.dp))

        // UserInfo, it contains users basic info such as Name, phone number, email, gender, age, country and state
        PersonalInfo(userProfileViewModel)
        Spacer(modifier = Modifier.height(20.dp))

        // Additional Info, it will contain the extra information such as religion, academic education, religious education
        // speciality areas, preferred languages, languages spoken
        AdditionalInfo(userProfileViewModel)
        Spacer(modifier = Modifier.height(20.dp))

        // Submit button, most difficult part, it will handle api request and lottie animation
        SubmitButton(userProfileViewModel, navController, context)

    }
}

@Composable
fun TopRow(navController: NavHostController){
    // Top Row containing the back icon and the Forgot Password Text
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(49.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        // Box which wraps the image
        Box(modifier = Modifier.fillMaxHeight(), contentAlignment = Alignment.CenterStart){
            // Icon contains the actual image
            Icon(
                Icons.Filled.ArrowBack, contentDescription = "Back",
                modifier = Modifier
                    .height(19.dp)
                    .width(28.dp)
                    .clickable { navController.navigate(LoginSignUpScreen.VerificationScreen.route) }
            )
        }
        // Box ends here
        Spacer(modifier = Modifier.width(16.25.dp))

        //Text containing Forgot Password
        Text(
            fontSize = 22.sp,
            fontFamily = FontFamily(Font(R.font.inter_bold)),
            text = "Profile Screen"
        )
    }
}

@Composable
fun ProfileHeader(){
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(80.dp)
    ) {
        // Image container
        Box(
            modifier = Modifier
                .size(80.dp)
                .background(Color(0xff8DDC68), CircleShape)
                .border(1.5.dp, Color.White, CircleShape),
            contentAlignment = Alignment.Center
        ){
            Icon(modifier = Modifier.size(30.dp),
                imageVector = ImageVector.vectorResource(id = R.drawable.user_vec_2),
                contentDescription = null, tint = Color.White
            )
        }

        Spacer(modifier = Modifier.width(20.dp))

        // Column containing the username and change profile text
        Column(
            modifier = Modifier
                .fillMaxHeight(),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                text = "Username",
                fontWeight = FontWeight.SemiBold,
                fontSize = 16.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium))
            )

            Text(
                text = "Change profile",
                fontWeight = FontWeight.SemiBold,
                fontSize = 14.sp,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                color = Color.Blue
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalInfo(viewModel: UserProfileViewModel){

    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.get_counselor_info()
    }

    // Main Column

    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Personal Info",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = placeholder_text
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Secondary Column
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(15.dp))
                .padding(20.dp)
        ) {
            // All of the rows corresponding to inputs are here
                // Name Field
                BasicUserProfileTextField(
                    label = "Name",
                    value = viewModel.name,
                    function = {
                        // viewModel.updateState(viewModel.name,it)
                     },
                    isLoading = isLoading
                )
                Spacer(modifier = Modifier.height(10.dp))

                // Phone Field
                BasicUserProfileTextField(
                    label = "Phone Number",
                    value = viewModel.phoneNumber,
                    function = {
                        //viewModel.updateState(viewModel.phoneNumber,it)
                    },
                    isLoading = isLoading
                )
                Spacer(modifier = Modifier.height(10.dp))

            // Email Field
            BasicUserProfileTextField(
                label = "Email",
                value = viewModel.email,
                function = { viewModel.updateState(viewModel.email,it) }
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Row which will cotain Age and Gender
            Row (
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                // Gender Dropdown
                BasicDropdownMenu(
                    label = "Gender",
                    modifier = Modifier.width(150.dp),
                    items = listOf("Male", "Female"),
                    function = { viewModel.updateState(viewModel.gender,it) }
                )
                Spacer(modifier = Modifier.width(20.dp))

                // Age Field
                BasicUserProfileTextField(
                    label = "Age",
                    value = viewModel.age,
                    function = { viewModel.updateState(viewModel.age,it) },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                )
            }
            Spacer(modifier = Modifier.height(10.dp))

        }
    }
}

@Composable
fun AdditionalInfo(userProfileViewModel: UserProfileViewModel){
    // Main Column
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        Text(
            text = "Additional Info",
            fontSize = 12.sp,
            fontWeight = FontWeight.Normal,
            color = placeholder_text
        )
        Spacer(modifier = Modifier.height(10.dp))

        // Secondary Column
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White, RoundedCornerShape(15.dp))
                .padding(20.dp)
        ) {
            // Religion Field
            BasicDropdownMenu(
                label = "Religion",
                modifier = Modifier.fillMaxWidth(),
                items = listOf("Islam", "Christianity", "Hinduism"),
                function = { userProfileViewModel.updateState(userProfileViewModel.religion,it) }
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Religious Education
            BasicDropdownMenu(
                label = "Religious Education",
                modifier = Modifier.fillMaxWidth(),
                items = listOf("Aalema", "Hafiz", "Imam"),
                function = { userProfileViewModel.updateState(userProfileViewModel.religiousEducation,it) }
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Academic Education
            BasicDropdownMenu(
                label = "Academic Education",
                modifier = Modifier.fillMaxWidth(),
                items = listOf("10th", "12th", "PhD"),
                function = { userProfileViewModel.updateState(userProfileViewModel.academicEducation,it) }
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Specialty Areas
            BasicDropdownMenu(
                label = "Specialty Areas",
                modifier = Modifier.fillMaxWidth(),
                items = listOf("General", "Dietary", "Marriage"),
                function = { userProfileViewModel.updateState(userProfileViewModel.specialtyAreas,it) }
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Preferred Languages
            BasicDropdownMenu(
                label = "Preferred Languages",
                modifier = Modifier.fillMaxWidth(),
                items = listOf("English", "Urdu", "Hindi", "Kashmiri"),
                function = { userProfileViewModel.updateState(userProfileViewModel.preferredLanguages,it) }
            )
            Spacer(modifier = Modifier.height(10.dp))

            // Languages Spoken
            BasicDropdownMenu(
                label = "Languages Spoken",
                modifier = Modifier.fillMaxWidth(),
                items = listOf("English", "Urdu", "Hindi", "Kashmiri"),
                function = { userProfileViewModel.updateState(userProfileViewModel.languagesSpoken,it) }
            )
            Spacer(modifier = Modifier.height(10.dp))
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun UserProfileScreenPreview(){
    UserProfileScreen(navController = rememberNavController())
}