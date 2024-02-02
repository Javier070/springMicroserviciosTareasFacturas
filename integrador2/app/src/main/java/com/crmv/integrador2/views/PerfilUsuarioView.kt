package com.crmv.integrador2.views

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController
import com.crmv.integrador2.R



@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PerfilUsuarioView(navController: NavController){

    val AzulClarito = Color(android.graphics.Color.parseColor("#c1d9d0"))

    Column(
        Modifier
            .fillMaxWidth()
            .fillMaxHeight()
            .background(color = Color(android.graphics.Color.parseColor("#eeeefb"))),
            horizontalAlignment = Alignment.CenterHorizontally
    ) {
        ConstraintLayout{
            val(topImg, profile) = createRefs()
            Box(
                Modifier
                    .fillMaxWidth()
                    .height(245.dp)
                    .constrainAs(topImg) {
                        top.linkTo(parent.top)
                        start.linkTo(parent.start)
                    }
                    .background(
                        color = Color(android.graphics.Color.parseColor("#102B3F")),
                        shape = RoundedCornerShape(bottomEnd = 40.dp, bottomStart = 40.dp)
                    )

            )
            IconButton(onClick = { /*TODO*/ }) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = null,
                    tint = Color.White)
                
            }
            Row(
                modifier = Modifier
                    .padding(top = 48.dp, start = 24.dp, end = 24.dp)
                    .fillMaxWidth()
            ) {
                Column(
                    modifier = Modifier
                        .height(100.dp)
                        .padding(start = 14.dp)
                        .weight(0.7f),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.Start

                ) {
                    Text(text = "hello",
                    color = Color.White,
                        fontSize = 18.sp
                    )
                    Text(text = "Javier Morales",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(top = 14.dp)
                        )
                }
                Image(painter = painterResource(
                    id = R.drawable.profile),
                    contentDescription =null,
                    modifier = Modifier
                        .width(100.dp)
                        .height(100.dp)
                        .clickable { }
                )

            }

            Button(
                onClick = { navController.navigate("MisProyectosView") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 350.dp, start = 24.dp, end = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(20.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF203C64),
                    contentColor = Color.Black
            )) {
                Text(text = "Gestionar Proyectos",
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

            }
            Button(
                onClick = {navController.navigate("MisFacturasView")},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 500.dp, start = 24.dp, end = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(20.dp)),
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFF203C64),
                    contentColor = Color.Black
                )
                    ) {
                Text(text = "Gestionar Facturas",
                    modifier = Modifier.padding(top = 10.dp, bottom = 10.dp),
                    fontSize = 27.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )

            }

            }

        }
}







