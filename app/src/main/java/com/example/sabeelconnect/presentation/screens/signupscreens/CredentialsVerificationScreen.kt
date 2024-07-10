package com.example.sabeelconnect.presentation.screens.signupscreens

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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.presentation.navigation.MAIN_SCREEN_ROUTE

@Composable
fun CredentialsVerificationScreen(navController: NavHostController){
    val colors = listOf(Color(0xffFEFEFE), Color(0xffDBFCDC)) // Define your colors
    val gradientBrush = Brush.verticalGradient(
        colors = colors,
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    )
    val scrollState = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush)
            .padding(horizontal = 30.dp, vertical = 40.dp)
            .verticalScroll(scrollState)
    ){

        // Top Row containing back icon and header text
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                Icons.Filled.ArrowBack, contentDescription = "Back",
                modifier = Modifier
                    .height(17.dp)
                    .width(25.dp)
                    .clickable { navController.navigate("userProfileScreen") }
            )
            Spacer(modifier = Modifier.width(30.dp))
            Text(text = "Credentials Verification", fontSize = 22.sp, fontWeight = FontWeight.Bold)
        }
        // Top Row ends here

        Spacer(modifier = Modifier.height(20.dp))

        // Text Row starts
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "1.  Identity Document", fontSize = 18.sp)
        }
        // Text Row ends

        Spacer(modifier = Modifier.height(20.dp))

        // First image row starts here
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            //Box for the actual content
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(175.dp)
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(1.dp, Color(0xffE5E3E2), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                // This Row will contain the actual image and text
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Image(
                        modifier = Modifier.size(55.dp),
                        painter = painterResource(id = R.drawable.upload_document_image),
                        contentDescription = null
                    )
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(text = "Upload documents", fontSize = 15.sp)
                }
            }
        }
        // First image Row end here

        Spacer(modifier = Modifier.height(30.dp))



        // Text Row starts
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "2.  Qualification", fontSize = 18.sp)
        }
        // Text Row ends

        Spacer(modifier = Modifier.height(20.dp))

        // Second image Row starts here
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(start = 20.dp),
            verticalAlignment = Alignment.CenterVertically
        ){
            //Box for the actual content
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(65.dp)
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .border(1.dp, Color(0xffE5E3E2), RoundedCornerShape(12.dp)),
                contentAlignment = Alignment.Center
            ){
                // This Row will contain the actual image and text
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Text(text = "Upload documents", fontSize = 15.sp)
                    Spacer(modifier = Modifier.width(20.dp))
                    Image(
                        modifier = Modifier.size(30.dp),
                        painter = painterResource(id = R.drawable.upload_document_image),
                        contentDescription = null
                    )
                }

            }
        }

        // Second Image row ends here

        Spacer(modifier = Modifier.height(150.dp))

        // Save and Finish Button
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier
                    .height(31.dp)
                    .width(205.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff1E844D)
                ),
                onClick = { navController.navigate(MAIN_SCREEN_ROUTE) },

                ) {
                Text(fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.inter_medium)),
                    text = "Save and Finish", color = Color.White,)
            }
        }

    }
}