package com.example.sabeelconnect.uicomponents

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sabeelconnect.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDropdownMenu(modifier: Modifier, list: List<String>){

    var isExpanded by remember { mutableStateOf(false) }
    var selectedText by remember { mutableStateOf(list[0]) }

    var rotation by remember { mutableFloatStateOf(0f) }



    Row(
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(
            modifier = Modifier
                .size(23.dp)
                .rotate(rotation)
            ,
            imageVector = Icons.Default.ArrowDropDown,
            contentDescription = null
        )

        ExposedDropdownMenuBox(
            modifier = modifier,
            expanded = isExpanded,
            onExpandedChange = {
                isExpanded = !isExpanded
                if(isExpanded) rotation = 180f
                else rotation = 0f
            }
        ) {
            TextField(
                modifier = Modifier
                    .menuAnchor()
                    .height(50.dp)
                    .padding(0.dp),
                value = selectedText,
                onValueChange = {},
                singleLine = true,
                readOnly = true,
                //trailingIcon = { ExposedDropdownMenuDefaults.TrailingIcon(expanded = isExpanded) },
                colors = TextFieldDefaults.textFieldColors(
                    containerColor = Color.White,
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                textStyle = TextStyle(
                    fontSize = 12.sp,
                    color = Color.Black
                )
            )

            ExposedDropdownMenu(modifier = Modifier.background(Color.White), expanded = isExpanded, onDismissRequest = { isExpanded = false; if(isExpanded) rotation = 180f
            else rotation = 0f  }) {
                list.forEachIndexed{ index, text ->
                    DropdownMenuItem(
                        text = { Text(text = text, color = Color.Black, fontSize = 12.sp, fontFamily = FontFamily(
                            Font(R.font.inter_medium)
                        )) },
                        onClick = {
                            selectedText = list[index]
                            isExpanded = false
                            if(isExpanded) rotation = 180f
                            else rotation = 0f
                        },
                        //contentPadding = ExposedDropdownMenuDefaults.ItemContentPadding
                    )
                }
            }
        }
    }

}