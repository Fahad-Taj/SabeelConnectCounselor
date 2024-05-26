package com.example.sabeelconnect.uicomponents


import androidx.annotation.DrawableRes
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sabeelconnect.R


// This is a composable that I will be using in many of my screens
// It is basically a TextField with a leadingIcon and some placeholder text
// It will accepts lambdas and parameters and also keyboard options and modifiers
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TextFieldComposable(
    modifier: Modifier,
    parameter: String,
    placeholder: String,
    @DrawableRes image:  Int,
    function: (String) -> Unit,
    keyboardOptions: KeyboardOptions
){

    var isSelected = remember { mutableStateOf(false) }
    var shouldShowPlaceholder = remember { mutableStateOf(true) }

    //This is the main Row and it will contain the image and the TextField
    Row(
        modifier = modifier,

        ){

        TextField(
            modifier = modifier.onFocusChanged {
                isSelected.value = !isSelected.value
                if(isSelected.value && parameter == "")
                    shouldShowPlaceholder.value = true
                else shouldShowPlaceholder.value = false },
            value =
            if (shouldShowPlaceholder.value)
                placeholder
            else parameter,
            onValueChange = { function(it) },
            leadingIcon = {
                Icon(modifier = Modifier.size(19.dp), painter = painterResource(id = image), contentDescription = null)
            },
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White,
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent
            ),
            textStyle = if(shouldShowPlaceholder.value) {
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
            shape = RoundedCornerShape(17.dp)
        )

    }
}