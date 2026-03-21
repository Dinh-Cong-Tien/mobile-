package tien.code.cupcake_app.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cupcake_app.composeapp.generated.resources.Res
import cupcake_app.composeapp.generated.resources.cupcake
import org.jetbrains.compose.resources.painterResource

@Composable
fun CupcakeImage() {
    Image(
        painter = painterResource(Res.drawable.cupcake),
        contentDescription = "Cupcake",
        modifier = Modifier.size(200.dp)
    )
}