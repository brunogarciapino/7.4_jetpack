import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key
import androidx.compose.ui.input.key.KeyEventType
import androidx.compose.ui.input.key.key
import androidx.compose.ui.input.key.type
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application


@OptIn(ExperimentalComposeUiApi::class)
@Composable
@Preview
fun App() {

    MaterialTheme {

        val fondo1 by remember { mutableStateOf(setOf("Imagenfondo2.jpg","R.jpg","A.png").random()) }
        var isDialogOpen2 by remember {mutableStateOf(false)}
        var isDialogOpen by remember {mutableStateOf(false)}
        var contador by remember { mutableStateOf(0) }
        var color by remember { mutableStateOf(Color.White) }
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

                    }
                Column(
                    modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    if (isDialogOpen) { //Esto solo se activara cuando isDialogOpen sea true, el cual abrira una ventana donde se mostrara el texto oculto
                        Dialog(
                            onCloseRequest = { isDialogOpen = false },
                            onPreviewKeyEvent = {
                                if (it.key == Key.Escape && it.type == KeyEventType.KeyDown) {
                                    isDialogOpen = false
                                    true
                                } else {
                                    false
                                }
                            }) {
                            Image(
                                painter = painterResource(fondo1),
                                contentDescription = "fondo"
                            )

                        }
                    }

                    Button(onClick = {
                        contador++
                        color = setOf(
                            Color.Blue,
                            Color.Red,
                            Color.Green,
                            Color.Black,
                            Color.Gray,
                            Color.Magenta,
                            Color.Yellow,
                            Color.DarkGray,
                            Color.White,
                            Color.Cyan,
                        ).random()

                        if (contador == 20)  {
                         isDialogOpen= true
                        }

                    }) {
                        Text(text = "Click ", color = Color.Magenta)
                        Text(text = "${contador}", color = Color.Green)
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
