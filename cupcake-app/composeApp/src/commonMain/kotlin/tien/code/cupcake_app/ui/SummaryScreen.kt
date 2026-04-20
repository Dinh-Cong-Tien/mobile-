package tien.code.cupcake_app.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SummaryScreen(
    onCancelButtonClicked: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        Text(
            text = "Order Summary",
            style = MaterialTheme.typography.titleLarge
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text("Quantity: 6")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Flavor: Red Velvet")
        Spacer(modifier = Modifier.height(8.dp))

        Text("Pickup Date: Tomorrow")
        Spacer(modifier = Modifier.height(8.dp))

        Text(
            text = "Total: $12.00",
            style = MaterialTheme.typography.titleMedium
        )

        Spacer(modifier = Modifier.weight(1f))

        Button(
            onClick = onCancelButtonClicked,
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(50)
        ) {
            Text("Cancel")
        }
    }
}