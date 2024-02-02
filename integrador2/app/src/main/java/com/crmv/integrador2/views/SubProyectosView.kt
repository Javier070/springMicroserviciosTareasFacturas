package com.crmv.integrador2.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.Checkbox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SubProyectosView(navController: NavController){

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(text = "", color = Color.White, fontWeight = FontWeight.Bold)
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(
                        onClick = { "navController.popBackStack()" }
                    ) {
                        Icon(imageVector = Icons.Default.Person, contentDescription = "Regresar", tint = Color.White)
                    }

                }
                , actions = {
                    IconButton(
                    onClick = { "navController.popBackStack()" },
                    modifier = Modifier.wrapContentSize(Alignment.TopEnd)
                ) {
                    Icon(imageVector = Icons.Default.Settings, contentDescription = "Regresar", tint = Color.White)
                }
                }
            )
        },content =  {
            Row {
                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier.padding(top = 70.dp)
                ) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "")
                    
                }
                Text(text = "Materias Primas",
                    modifier = Modifier.padding(top = 80.dp, start = 55.dp),
                    style = TextStyle(
                        fontSize = 25.sp,
                        fontWeight = FontWeight.Bold,
                        fontStyle = FontStyle.Normal
                    )
                    )
                IconButton(onClick = { /*TODO*/ },
                    modifier = Modifier.padding(top = 70.dp, start = 60.dp)
                ) {
                    Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")

                }
            }
            val (checkedState, onStateChange) = remember { mutableStateOf(true) }
            Column(modifier = Modifier.padding(top = 200.dp, start = 40.dp)) {
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = null // null recommended for accessibility with screenreaders
                    )
                    Text(
                        text = "Recoger al bebe",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier.padding( start = 100.dp)
                    ) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")

                    }
                }
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = null // null recommended for accessibility with screenreaders
                    )
                    Text(
                        text = "Recoger al bebe",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier.padding( start = 100.dp)
                    ) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")

                    }
                }
                Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
                    Checkbox(
                        checked = checkedState,
                        onCheckedChange = null // null recommended for accessibility with screenreaders
                    )
                    Text(
                        text = "Recoger al bebe",
                        style = MaterialTheme.typography.bodyLarge,
                        modifier = Modifier.padding(start = 16.dp)
                    )
                    IconButton(onClick = { /*TODO*/ },
                        modifier = Modifier.padding( start = 100.dp)
                    ) {
                        Icon(imageVector = Icons.Default.MoreVert, contentDescription = "")

                    }
                }

            }


    })
}

