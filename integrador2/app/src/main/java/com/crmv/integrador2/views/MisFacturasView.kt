package com.crmv.integrador2.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.navigation.NavController


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MisFacturasView(navController: NavController){

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
            IconButton(onClick = { navController.navigate("PerfilUsuarioView") }) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = null,
                    tint = Color.White)

            }


            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 60.dp, start = 24.dp, end = 24.dp)
                    .shadow(3.dp, shape = RoundedCornerShape(20.dp))
                    .background(
                        color = Color.Cyan,
                        shape = RoundedCornerShape(20.dp)
                    )


            ) {
                Column(
                    modifier = Modifier
                        .padding(top = 12.dp, bottom = 12.dp, end = 12.dp)
                        .height(90.dp),
                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(text = "Importe:",
                        modifier = Modifier.padding(top = 23.dp),
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )


                }

            }

            Row(

                horizontalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 300.dp, start = 24.dp, end = 24.dp)
                    .shadow(1.dp, shape = RoundedCornerShape(2.dp))
                    .background(
                        color = Color.Transparent,
                        shape = RoundedCornerShape(20.dp)
                    )


            ) {
                Column(

                    modifier = Modifier
                        .padding(top = 5.dp, end = 12.dp)
                        .height(450.dp),

                    horizontalAlignment = Alignment.CenterHorizontally

                ) {
                    Text(text = "Gestionar Facturas",
                        modifier = Modifier.padding(top = 23.dp),
                        fontSize = 27.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                    LazyColumn(
                        verticalArrangement = Arrangement.spacedBy(30.dp),
                        modifier = Modifier.padding(
                            start = 20.dp,
                            bottom = 50.dp,
                            top = 40.dp)

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

            }
        }




    }

}

