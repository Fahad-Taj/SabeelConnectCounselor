package com.example.sabeelconnect.presentation.screens.signupscreens.CounselorProfile

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.TextStyle
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
import com.example.sabeelconnect.presentation.ui.theme.placeholder_text
import com.example.sabeelconnect.presentation.ui.theme.primary_green
import kotlin.math.exp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BasicUserProfileTextField(
    label: String,
    value: MutableState<String>,
    function: (String) -> Unit,
    keyboardOptions: KeyboardOptions? = null,
    isLoading: Boolean? = null,
) {
    // Text Field
    if(isLoading == true){
        CircularProgressIndicator()
    } else {
        TextField(
            modifier = Modifier
                .fillMaxWidth()
                .border(0.6.dp, placeholder_text, RoundedCornerShape(15.dp))
                .clip(RoundedCornerShape(15.dp)),
            label = {
                Text(
                    text = label,
                    color = placeholder_text,
                    fontSize = 12.sp,
                    fontWeight = FontWeight.Normal,
                    fontFamily = FontFamily(Font(R.font.inter_medium))
                )
            },
            value = value.value,
            onValueChange = { function(it) },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = TextStyle(
                fontSize = 15.sp,
                fontWeight = FontWeight.Normal,
                fontFamily = FontFamily(Font(R.font.inter_medium)),
                color = Color.Black
            ),
            keyboardOptions = keyboardOptions ?: KeyboardOptions(keyboardType = KeyboardType.Text)
        )
    }

}

@Composable
fun BasicDropdownMenu(
    label: String,
    modifier: Modifier,
    items: List<String>,
    function: (String) -> Unit
) {
    var expanded by remember { mutableStateOf(false) }
    var selectedIndex by remember { mutableStateOf(0) }

    Box(modifier = modifier.border(0.6.dp, placeholder_text, RoundedCornerShape(15.dp))) {
        TextButton(modifier = modifier, onClick = { expanded = true }) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = label,
                        color = placeholder_text,
                        fontSize = 12.sp,
                        fontFamily = FontFamily(
                            Font(R.font.inter_medium)
                        )
                    )
                    Icon(
                        modifier = Modifier.rotate(if (expanded) 180f else 0f),
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = null,
                        tint = placeholder_text
                    )
                }
                Spacer(modifier = Modifier.width(20.dp))

                Text(
                    text = items[selectedIndex],
                    color = Color.Black,
                    fontSize = 14.sp,
                    fontFamily = FontFamily(Font(R.font.inter_medium))
                )
            }
        }

        DropdownMenu(
            modifier = Modifier.background(Color.White),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            items.forEachIndexed { index, item ->
                DropdownMenuItem(
                    modifier = Modifier.background(Color.White),
                    onClick = {
                        selectedIndex = index
                        expanded = false
                        function(items[selectedIndex])
                    }) {
                    Text(text = item, color = Color.Black)
                }
            }
        }
    }
}

@Composable
fun SubmitButton(
    userProfileViewModel: UserProfileViewModel,
    navController: NavHostController,
    context: Context
){

    val response by userProfileViewModel.response.collectAsState()

    val isAwaiting by userProfileViewModel.awaitingResponse
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
            .height(58.dp)
            .width(160.dp)
            .background(color, RoundedCornerShape(18.dp))
            .clip(RoundedCornerShape(18.dp))
            .clickable(enabled = isClickable) { userProfileViewModel.submitButtonClicked() },
        contentAlignment = Alignment.Center
    ){
        if(!isAwaiting){
            Text(
                text = "Submit",
                style = SabeelBasicTextStyle,
                color = Color.White
            )
        } else {
            CircularProgressIndicator(color = Color.White)
        }

        LaunchedEffect(key1 = response) {
            response?.let {
                if(response?.isSuccessful == true){
                    navController.navigate(com.example.sabeelconnect.presentation.screens.LoginSignUpScreen.CredentialsVerificationScreen.route)
                    Toast.makeText(context, response?.message()?.toString(), Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(context, response?.message().toString(), Toast.LENGTH_SHORT).show()
                }
            }
        }

    }
}

val SabeelBasicTextStyle = TextStyle(
    fontSize = 14.sp,
    fontFamily = FontFamily(Font(R.font.inter_medium)),
    fontWeight = FontWeight.SemiBold
)

@Preview(showBackground = true)
@Composable
fun SubmitButtonPreview(){
    val context = LocalContext.current
    SubmitButton(UserProfileViewModel(), rememberNavController(), context)
}