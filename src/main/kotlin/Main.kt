import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@Composable
@Preview
fun App() {

    MaterialTheme {
        var contador by remember { mutableStateOf(0) }
        var color by remember { mutableStateOf(androidx.compose.ui.graphics.Color.White) }
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = color
        ) {
            Image(
                painter = painterResource("fondo.jpg"),
                contentDescription = "fondo"
            )

            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.Start
            ) {
                IconButton(onClick =) {
                    Icon(
                        painter = painterResource("jet.png"),
                        contentDescription = null
                    )
                }

                Column(
                    modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {

                    Button(onClick = {
                        contador++
                        color = setOf(
                            androidx.compose.ui.graphics.Color.Blue,
                            androidx.compose.ui.graphics.Color.Red,
                            androidx.compose.ui.graphics.Color.Green,
                            androidx.compose.ui.graphics.Color.Black,
                            androidx.compose.ui.graphics.Color.Gray,
                            androidx.compose.ui.graphics.Color.Magenta,
                            androidx.compose.ui.graphics.Color.Yellow,
                            androidx.compose.ui.graphics.Color.DarkGray,
                            androidx.compose.ui.graphics.Color.White,
                            androidx.compose.ui.graphics.Color.Cyan,
                        ).random()

                    }) {
                        Text(text = "Click ", color = androidx.compose.ui.graphics.Color.Magenta)
                        Text(text = "${contador}", color = androidx.compose.ui.graphics.Color.Green)
                    }
                }
            }
        }
    }
}


fun main() = application {
    Window(onCloseRequest = ::exitApplication, icon = painterResource("google.png")) {
        App()
    }
}
