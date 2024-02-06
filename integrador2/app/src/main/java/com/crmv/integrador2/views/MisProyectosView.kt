package com.crmv.integrador2.views

import android.annotation.SuppressLint
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.MoreVert

import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.KeyboardArrowDown
import androidx.compose.material.icons.rounded.KeyboardArrowUp
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.crmv.integrador2.components.SearchBar
import com.crmv.integrador2.navigation.AppScreens

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MisProyectosView(navController: NavController) {

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
                        onClick = { navController.navigate("PerfilUsuarioView") }
                    ) {
                        Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Regresar", tint = Color.White)
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
        },
 content = {innerPadding ->
     Column {


     SearchBar()
     Row(
         verticalAlignment = Alignment.CenterVertically,
         horizontalArrangement = Arrangement.Center,
         modifier = Modifier
             .fillMaxWidth()
             .padding(start = 12.dp, end = 12.dp)
             .shadow(3.dp, shape = RoundedCornerShape(10.dp))
             .background(
                 color = Color.Gray,
                 shape = RoundedCornerShape(2.dp)
             )





     ) {
         Text(text = "Mis proyectos",
             modifier = Modifier.padding(start = 23.dp),
             fontSize = 20.sp,
             fontWeight = FontWeight.Bold,
             color = Color.White
         )
         IconButton(onClick = { /*TODO*/ },
             modifier = Modifier.padding(start = 140.dp)) {
             Icon(
                 imageVector = Icons.Default.Add,
                 contentDescription = null,
                  tint = Color.White
             )

         }
         IconButton(onClick = { /*TODO*/ },
             ) {
             Icon(
                 imageVector = Icons.Default.MoreVert,
                 contentDescription = null,
                 tint = Color.White
             )

         }

     }
     LazyColumn(

         verticalArrangement = Arrangement.spacedBy(32.dp),
         modifier = Modifier.padding(top = 40.dp,
             start = 20.dp)
     ) {
         val list = (1..75).map { it.toString() }
         items(count = list.size) {
             Text(
                 text = list[it],
                 style = MaterialTheme.typography.bodyLarge,
                 modifier = Modifier
                     .fillMaxWidth()
                     .padding(horizontal = 16.dp)
             )
         }
     }
     }
     }  )

}











