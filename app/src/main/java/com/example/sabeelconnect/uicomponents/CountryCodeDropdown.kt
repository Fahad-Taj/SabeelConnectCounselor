package com.example.sabeelconnect.uicomponents

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sabeelconnect.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CountryCodeDropdown(
    modifier: Modifier,
    map: Map<String, Pair<String, Int>>
){
    var isExpanded by remember { mutableStateOf(false) }
    var selectedText by remember {
        mutableStateOf(Pair("Afghanistan", Pair("+93", R.drawable.flag_afghanistan)))
    }

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
            Row(
                modifier = Modifier
                    .height(50.dp)
                    .fillMaxWidth()
                    .padding(0.dp)
                    .menuAnchor(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    fontSize = 15.sp,
                    text = selectedText.second.first,
                    color = Color.Black
                )
                Image(modifier = Modifier.size(20.dp), painter = painterResource(id = selectedText.second.second), contentDescription = null)
            }
            ExposedDropdownMenu(modifier = Modifier.width(200.dp).background(Color.White),
                expanded = isExpanded, onDismissRequest = { isExpanded = false }) {

                map.forEach{ (countryName, pair) ->
                    DropdownMenuItem(
                        text = { Text(fontSize = 15.sp, text = countryName, color = Color.Black) },
                        trailingIcon = {
                            Image(modifier = Modifier.size(25.dp), painter = painterResource(id = pair.second), contentDescription = null)
                        },
                        onClick = {
                            selectedText = Pair(countryName, Pair(pair.first, pair.second))
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