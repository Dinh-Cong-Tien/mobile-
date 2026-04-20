package tien.code.cupcake_app

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import tien.code.cupcake_app.CupcakeApp

fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        CupcakeApp()
    }
}