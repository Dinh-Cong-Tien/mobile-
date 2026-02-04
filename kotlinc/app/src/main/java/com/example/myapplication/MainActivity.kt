package com.example.myapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.myapplication.ui.theme.MyApplicationTheme
import kotlinx.coroutines.delay
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApplicationTheme {
                DiceRollerApp()
            }
        }
    }
}

@Composable
fun DiceRollerApp() {
    var diceNumber by remember { mutableStateOf(1) }
    var isRolling by remember { mutableStateOf(false) }
    
    // Animation xoay khi đang roll
    val infiniteTransition = rememberInfiniteTransition(label = "dice_spin")
    val spinAngle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(300, easing = LinearEasing),
            repeatMode = RepeatMode.Restart
        ),
        label = "spin"
    )
    
    val displayAngle = if (isRolling) spinAngle else 0f

    val diceImage = when (diceNumber) {
        1 -> R.drawable.dice_1
        2 -> R.drawable.dice_2
        3 -> R.drawable.dice_3
        4 -> R.drawable.dice_4
        5 -> R.drawable.dice_5
        else -> R.drawable.dice_6
    }
    
    // Xử lý animation roll
    LaunchedEffect(isRolling) {
        if (isRolling) {
            delay(800)
            diceNumber = Random.nextInt(1, 7)
            isRolling = false
        }
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(id = diceImage),
            contentDescription = "Dice",
            modifier = Modifier
                .size(160.dp)
                .rotate(displayAngle)
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = { if (!isRolling) isRolling = true },
            enabled = !isRolling
        ) {
            Text(if (isRolling) "Đang lắc..." else "Roll Dice 🎲")
        }
    }
}