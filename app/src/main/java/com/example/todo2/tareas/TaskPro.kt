package com.example.todo2.tareas

import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.todo2.R


@Composable
fun ExampleContent(taskName: String) {
    // Primer elemento: Imagen con borde y tamaño específico
    val firstElementModifier = Modifier
        .border(width = 2.dp, color = Color(0xFFDADADA))
        .padding(2.dp)
        .width(24.dp)
        .height(24.dp)

    Image(
        painter = painterResource(id = R.drawable.check),
        contentDescription = "image description",
        modifier = firstElementModifier
    )

    // Segundo elemento
    // No necesitas agregar nada específico aquí, ya que el Checkmark es suficiente.

    // Tercer elemento
    val thirdElementModifier = Modifier
        .width(343.dp)
        .height(24.dp)

    Text(
        text = taskName,
        fontSize = 18.sp,
        lineHeight = 24.sp,
        fontWeight = FontWeight(500),
        color = Color(0xFF575767),
        modifier = thirdElementModifier
    )
}
@Composable
@Preview
 fun MuestraVista(): Unit {


}