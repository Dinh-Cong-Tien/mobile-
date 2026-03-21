package tien.code.cupcake_app

import androidx.compose.runtime.*
import tien.code.cupcake_app.ui.FlavorScreen
import tien.code.cupcake_app.ui.PickupScreen
import tien.code.cupcake_app.ui.StartOrderScreen
import tien.code.cupcake_app.ui.SummaryScreen
import tien.code.cupcake_app.ui.*

@Composable
fun CupcakeApp() {

    var currentScreen by remember { mutableStateOf(CupcakeScreen.Start) }

    when (currentScreen) {

        CupcakeScreen.Start -> {
            StartOrderScreen(
                onNextButtonClicked = {
                    currentScreen = CupcakeScreen.Flavor
                }
            )
        }

        CupcakeScreen.Flavor -> {
            FlavorScreen(
                onNextButtonClicked = {
                    currentScreen = CupcakeScreen.Pickup
                },
                onCancelButtonClicked = {
                    currentScreen = CupcakeScreen.Start
                }
            )
        }

        CupcakeScreen.Pickup -> {
            PickupScreen(
                onNextButtonClicked = {
                    currentScreen = CupcakeScreen.Summary
                },
                onCancelButtonClicked = {
                    currentScreen = CupcakeScreen.Start
                }
            )
        }

        CupcakeScreen.Summary -> {
            SummaryScreen(
                onCancelButtonClicked = {
                    currentScreen = CupcakeScreen.Start
                }
            )
        }
    }
}