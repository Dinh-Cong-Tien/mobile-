package com.example.myapplication 

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(
                modifier = Modifier.fillMaxSize(),
                color = Color(0xFFD2E8D4)
            ) {
                BusinessCardApp() 
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    val androidGreen = Color(0xFF3DDC84)
    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Column(
            modifier = Modifier.weight(1f).fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Box(modifier = Modifier.size(100.dp).background(Color(0xFF073042))) {
                Icon(
                    imageVector = Icons.Default.Share,
                    contentDescription = null,
                    tint = androidGreen,
                    modifier = Modifier.fillMaxSize().padding(8.dp)
                )
            }
            Text(text = "ABC", fontSize = 40.sp, fontWeight = FontWeight.Light)
            Text(text = "Danh thiếp", fontSize = 16.sp, fontWeight = FontWeight.Bold, color = androidGreen)
        }

        Column(
            modifier = Modifier.fillMaxWidth().padding(bottom = 32.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            ContactRow(Icons.Default.Phone, "+84 123 456 789", androidGreen)
            ContactRow(Icons.Default.Share, "@socialmedia", androidGreen)
            ContactRow(Icons.Default.Email, "abc@gmail.com", androidGreen)
        }
    }
}

@Composable
fun ContactRow(icon: ImageVector, text: String, tint: Color) {
    Row(
        modifier = Modifier.fillMaxWidth().padding(start = 50.dp, top = 8.dp, bottom = 8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Icon(imageVector = icon, contentDescription = null, tint = tint, modifier = Modifier.size(24.dp))
        Spacer(modifier = Modifier.width(16.dp))
        Text(text = text, fontSize = 16.sp)
    }
}