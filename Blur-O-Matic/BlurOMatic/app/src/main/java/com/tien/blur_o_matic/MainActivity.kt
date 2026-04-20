package com.tien.blur_o_matic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import com.tien.blur_o_matic.ui.BlurSelectionScreen
import com.tien.blur_o_matic.ui.theme.BlurOMaticTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BlurOMaticTheme {
                MainContent()
            }
        }
    }
}

@Composable
fun MainContent() {
    var selectedImageUri by remember { mutableStateOf<String?>(null) }

    val imagePickerLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.GetContent()
    ) { uri ->
        if (uri != null) {
            selectedImageUri = uri.toString()
        }
    }

    BlurSelectionScreen(
        imageUri = selectedImageUri,
        onImageSelect = {
            imagePickerLauncher.launch("image/*")
        },
        onStartBlur = { blurLevel ->
            // Handle blur with selected level
            // TODO: Implement blur logic with blurLevel (1, 2, or 3)
        },
        modifier = Modifier.fillMaxSize()
    )
}
