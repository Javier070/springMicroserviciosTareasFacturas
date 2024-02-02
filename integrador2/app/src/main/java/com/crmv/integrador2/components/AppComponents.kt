package com.crmv.integrador2.components

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
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
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.crmv.integrador2.R
import com.crmv.integrador2.ui.theme.TextColor

@Composable
fun NormalTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .fillMaxWidth()
            .heightIn(min = 80.dp),
        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Normal,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Center
    )

}

@Composable
fun HeadingTextComponent(value: String) {
    Text(
        text = value,
        modifier = Modifier
            .padding( start = 22.dp, top = 10.dp),

        style = TextStyle(
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal
        ),
        color = TextColor,
        textAlign = TextAlign.Left
    )

}

@Composable
fun ButtonComponent() {

    Column(
        modifier = Modifier
            .padding(20.dp)
            .padding(top = 300.dp)
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


        Button(
            onClick = { "" },

            ) {
            Text(text = "Gestionas proyectos")
        }
        Button(
            onClick = { "" },
            modifier = Modifier.padding(top = 30.dp)
        ) {
            Text(text = "Gestionas facturas")
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyTextField() {

    /* val textValue = remember { mutableStateOf("Inicial") }


     OutlinedTextField(
 label = {Text(text = labelValue)},
 value = textValue,
 colors = TextFieldDefaults.outlinedTextFieldColors(
     focusedBorderColor = Color.Blue,
     focusedLabelColor = Color.Blue,
     cursorColor = Color.Blue,
 ),
 keyboardOptions = KeyboardOptions.Default,
 onValueChange = {it: String textValue.value = it})*/
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchBar() {


    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, top = 32.dp, end = 16.dp)
    ) {

        OutlinedTextField(
            value = "", onValueChange = { "" },
            label = {
                Text(
                    text = "Buscador",
                    color = Color.Black,
                    fontSize = 14.sp
                )
            },
            leadingIcon = {
             Icon(imageVector = Icons.Default.Search, contentDescription = null)
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp , vertical = 60.dp), maxLines = 1,
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = Color(0xff67A4FF), unfocusedBorderColor = Color.Black,
            )
        )
/*
        // Botón de limpiar búsqueda
        if (text.isNotEmpty()) {
            IconButton(
                onClick = { onClearClick() },
                modifier = Modifier.padding(start = 8.dp)
            ) {
                Icon(imageVector = Icons.Default.Clear, contentDescription = null)
            }
        }
 */

    }
}

