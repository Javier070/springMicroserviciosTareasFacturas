package com.example.todo2.tareas


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todo2.R
import com.example.todo2.ui.theme.TODO2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TODO2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Helloo $name!",
        modifier = modifier
    )
}

@Preview
@Composable
fun TaskItem() {
}

@Composable
fun TaskItem(taskName: String, isComplete: Boolean) {
    // Estado para mantener la imagen actual
    var isChecked by remember { mutableStateOf(isComplete) }

    // Primer elemento
    val firstElementModifier = Modifier
        .width(188.dp)
        .height(11.90186.dp)

    Row(
        modifier = firstElementModifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp, Alignment.Start),
        verticalAlignment = Alignment.Top
    ) {
        // Child views del primer elemento.
        // Puedes agregar más componentes dentro de esta fila según tus necesidades

        // Imagen que cambia según el estado y es clickeable
        Image(
            painter = if (isChecked) painterResource(id = R.drawable.checkcomplete) else painterResource(id = R.drawable.check),
            contentDescription = "image description",
            modifier = Modifier
                .clickable {
                    // Cambiar el estado al hacer clic
                    isChecked = !isChecked
                }
                .width(24.dp)
                .height(24.dp)
        )

        // Segundo elemento
        // No necesitas agregar nada específico aquí, ya que el Checkmark es suficiente.

        // Tercer elemento
        val thirdElementModifier = Modifier
            .fillMaxWidth()  // Utiliza fillMaxWidth en lugar de un ancho fijo
            .height(24.dp)

        Text(
            text = taskName,
            fontSize = 8.sp,
            lineHeight = 24.sp,
            fontWeight = FontWeight(500),
            color = Color(0xFF575767),
            modifier = thirdElementModifier
        )
    }
}


@Preview@Composable
fun MiPantalla() {
    Box(
        modifier = Modifier
            .width(375.dp)
            .height(812.dp)
            .background(color = Color(0xFFFFFFFF))
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            Text(
                text = "9:27",
                fontSize = 15.sp,
                fontWeight = FontWeight(600),
                color = Color(0xFF000000),
                textAlign = TextAlign.Start,
                modifier = Modifier.padding(8.dp)
            )

            Text(
                text = "Materias Primas",
                fontSize = 24.sp,
                fontWeight = FontWeight(400),
                color = Color(0xFF000000),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(8.dp)
            )

            // Cambiado de Row a Column
            Column(

            ) {
                TaskItem("Ejemplo de tarea 1", false)
                TaskItem("Ejemplo de tarea 2", true)
                TaskItem("Ejemplo de tarea 4", false)
                // Puedes agregar más tareas según sea necesario
            }
        }
    }
}




@Composable
fun GreetingPreview() {
    TODO2Theme {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Blue),
            contentAlignment =  Alignment.Center,


            ) {

            Greeting("Antonio")
            Greeting("Android", modifier = Modifier.align(Alignment.BottomEnd))
        }




    }
}