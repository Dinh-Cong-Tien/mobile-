package tien.code.cupcake_app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun FlavorScreen(
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit
) {
    val options = listOf(
        "Vanilla", "Chocolate", "Red Velvet",
        "Salted Caramel", "Coffee"
    )

    var selected by remember { mutableStateOf("Red Velvet") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Choose Flavor",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        options.forEach { flavor ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (flavor == selected),
                    onClick = { selected = flavor }
                )
                Text(flavor)
            }
        }

        Divider(modifier = Modifier.padding(vertical = 16.dp))

        Spacer(modifier = Modifier.weight(1f))

        // 🔥 Subtotal căn phải
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.End
        ) {
            Text("Subtotal $12.00")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // 🔥 Button giống Google
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            OutlinedButton(
                onClick = onCancelButtonClicked,
                shape = RoundedCornerShape(50)
            ) {
                Text("Cancel")
            }

            Button(
                onClick = onNextButtonClicked,
                shape = RoundedCornerShape(50)
            ) {
                Text("Next")
            }
        }
    }
}