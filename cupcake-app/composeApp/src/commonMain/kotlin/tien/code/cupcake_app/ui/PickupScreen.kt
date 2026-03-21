package tien.code.cupcake_app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun PickupScreen(
    onNextButtonClicked: () -> Unit,
    onCancelButtonClicked: () -> Unit
) {
    val options = listOf(
        "Tomorrow",
        "Next Monday",
        "Next Friday"
    )

    var selected by remember { mutableStateOf(options[0]) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Choose Pickup Date",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(16.dp))

        // 🔥 Radio chọn ngày
        options.forEach { date ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                RadioButton(
                    selected = (date == selected),
                    onClick = { selected = date }
                )
                Text(date)
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // 🔥 Button đẹp hơn
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