package com.example.sabeelconnect.presentation.screens.signupscreens

import android.content.Context
import android.net.Uri
import android.util.Log
import android.widget.Toast
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.sabeelconnect.R
import com.example.sabeelconnect.presentation.navigation.MAIN_SCREEN_ROUTE
import java.io.File


// Very simple composable, containes 2 boxes which will trigger the file picker and one submit button
// which will make the api call
@Composable
fun CredentialsVerificationScreen(navController: NavHostController){

    // Background colors and scroll statevariables
    val colors = listOf(Color(0xffFEFEFE), Color(0xffDBFCDC)) // Define your colors
    val gradientBrush = Brush.verticalGradient(
        colors = colors,
        startY = 0f,
        endY = Float.POSITIVE_INFINITY
    )
    val scrollState = rememberScrollState()

    // Context variable will be used when we convert uri to a file object
    val context = LocalContext.current

    // Viewmodel variable
    val credentialsViewModel: CredentialsVerificationViewModel = viewModel()

    // Response varibles
    val response1 by credentialsViewModel.response1.collectAsState()
    val response2 by credentialsViewModel.response2.collectAsState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(brush = gradientBrush)
            .padding(horizontal = 30.dp, vertical = 40.dp)
            .verticalScroll(scrollState)
    ){

        // Here I will declare the file picker variables, first I will get 2 uris and when the user clicks
        // submit button then the URIs will be converted into File objects and sent to the api endpoint

        // These variables are used to store the object uris
        var myUri1: Uri? = null
        var myUri2: Uri? = null

        // Two launchers for two seperate files, there is probably a better way to do this but I will
        // just follow this for now
        val launcher1 = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            uri?.let {
                myUri1 = uri
            }
        }

        val launcher2 = rememberLauncherForActivityResult(
            contract = ActivityResultContracts.GetContent()
        ) { uri: Uri? ->
            uri?.let {
                myUri2 = uri
            }
        }

        // Top Row containing back icon and header text ---------------------------------------------
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
        // Top Row ends here ---------------------------------------------------------------------------

        Spacer(modifier = Modifier.height(20.dp))

        // Text Row starts  -----------------------------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "1.  Identity Document", fontSize = 18.sp)
        }
        // Text Row ends --------------------------------------------------------------------------

        Spacer(modifier = Modifier.height(20.dp))

        // First image row starts here ------------------------------------------------------------
        // First launcher will be invoked here
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
                    .border(1.dp, Color(0xffE5E3E2), RoundedCornerShape(12.dp))
                    .clickable { launcher1.launch("*/*") },
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
        // First image Row end here ----------------------------------------------------------------

        Spacer(modifier = Modifier.height(30.dp))

        // Text Row starts ------------------------------------------------------------------------
        Row(
            modifier = Modifier
                .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ){
            Text(text = "2.  Qualification", fontSize = 18.sp)
        }
        // Text Row ends --------------------------------------------------------------------------

        Spacer(modifier = Modifier.height(20.dp))

        // Second image Row starts here -----------------------------------------------------------
        // Second launcher will be invoked here
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
                    .border(1.dp, Color(0xffE5E3E2), RoundedCornerShape(12.dp))
                    .clickable { launcher2.launch("*/*") },
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

        // Second Image row ends here -------------------------------------------------------------

        Spacer(modifier = Modifier.height(150.dp))

        // Save and Finish Button -----------------------------------------------------------------
        // This button will convert the objecturis to file objects and return them to api through viewmodel
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Button(
                modifier = Modifier
                    .height(31.dp)
                    .width(205.dp),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xff1E844D)
                ),
                onClick = {
                    // Two file objects are being created here
                    if(!(myUri1 == null || myUri2 == null)){
                        val file1 = uriToFile(context, myUri1!!)
                        val file2 = uriToFile(context, myUri2!!)

                        credentialsViewModel.IdUpload(file1)
                        credentialsViewModel.QualUpload(file2)
                    }
//                    navController.navigate(MAIN_SCREEN_ROUTE)
                          },

                ) {
                Text(fontSize = 12.sp, fontFamily = FontFamily(Font(R.font.inter_medium)),
                    text = "Save and Finish", color = Color.White,)
            }
        }

    }
    LaunchedEffect(response1, response2) {
        Log.e("CredentialsVerificationViewModel, Response1", response1?.message().toString())
        Log.e("CredentialsVerificationViewModel, Response1", response1?.body().toString())
        Log.e("CredentialsVerificationViewModel, Response1", response1?.code().toString())

        Log.e("CredentialsVerificationViewModel, Response2", response1?.message().toString())
        Log.e("CredentialsVerificationViewModel, Response2", response1?.body().toString())
        Log.e("CredentialsVerificationViewModel, Response2", response1?.code().toString())

        response1?.let {
            Toast.makeText(context, response1!!.message().toString(), Toast.LENGTH_SHORT).show()
        }

        if(response1?.isSuccessful() == true && response2?.isSuccessful() == true){
            navController.navigate(MAIN_SCREEN_ROUTE)
        }
    }

}

fun uriToFile(context: Context, uri: Uri): File{
    val inputStream = context.contentResolver.openInputStream(uri)
    val tempFile = File(context.cacheDir, uri.lastPathSegment ?: "tempFile")
    inputStream.use { input ->
        tempFile.outputStream().use { output ->
            input?.copyTo(output)
        }
    }
    return tempFile
}