package com.tien.blur_o_matic.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.PlayArrow
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.tien.blur_o_matic.R
import com.tien.blur_o_matic.ui.theme.DarkTeal
import com.tien.blur_o_matic.ui.theme.TealBackground
import kotlin.math.absoluteValue

data class BlurOption(
    val level: Int,
    val label: String,
    val description: String,
    val intensity: String
)

data class DrawableImage(
    val resourceId: Int,
    val name: String
)

@Composable
fun BlurSelectionScreen(
    imageUri: String? = null,
    onImageSelect: () -> Unit = {},
    onStartBlur: (Int) -> Unit = {},
    modifier: Modifier = Modifier
) {
    var selectedBlurLevel by remember { mutableStateOf(1) }
    var selectedDrawableId by remember { mutableStateOf(R.drawable.anh1) }
    var showImagePicker by remember { mutableStateOf(false) }
    var blurActive by remember { mutableStateOf(false) }

    // List of available drawable images from res/drawable/
    val availableDrawables = listOf(
        DrawableImage(R.drawable.anh1, "Image 1"),
        DrawableImage(R.drawable.anh2, "Image 2")
        // Thêm ảnh mới: DrawableImage(R.drawable.your_image, "Display Name")
    )

    val blurOptions = listOf(
        BlurOption(1, "Light (Sigma 5)", "Slight blur", "5"),
        BlurOption(2, "Medium (Sigma 10)", "Medium blur", "10"),
        BlurOption(3, "Heavy (Sigma 25)", "Maximum blur", "25")
    )

    // Dialog chọn ảnh từ drawable
    if (showImagePicker) {
        AlertDialog(
            onDismissRequest = { showImagePicker = false },
            title = { Text("Select Image") },
            text = {
                LazyVerticalGrid(
                    columns = GridCells.Fixed(2),
                    modifier = Modifier
                        .fillMaxWidth()
                        .heightIn(max = 400.dp),
                    horizontalArrangement = Arrangement.spacedBy(12.dp),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    items(availableDrawables) { drawable ->
                        Card(
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(100.dp)
                                .shadow(4.dp, RoundedCornerShape(12.dp))
                                .clickable {
                                    selectedDrawableId = drawable.resourceId
                                    showImagePicker = false
                                }
                                .then(
                                    if (selectedDrawableId == drawable.resourceId) {
                                        Modifier.border(3.dp, DarkTeal, RoundedCornerShape(12.dp))
                                    } else {
                                        Modifier
                                    }
                                ),
                            shape = RoundedCornerShape(12.dp),
                            colors = CardDefaults.cardColors(containerColor = Color.White)
                        ) {
                            Box(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .clip(RoundedCornerShape(12.dp)),
                                contentAlignment = Alignment.Center
                            ) {
                                Image(
                                    painter = painterResource(id = drawable.resourceId),
                                    contentDescription = drawable.name,
                                    modifier = Modifier.fillMaxSize(),
                                    contentScale = ContentScale.Crop
                                )
                                if (selectedDrawableId == drawable.resourceId) {
                                    Box(
                                        modifier = Modifier
                                            .fillMaxSize()
                                            .background(Color.Black.copy(alpha = 0.3f)),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Text(
                                            "✓",
                                            fontSize = 28.sp,
                                            color = Color.White,
                                            fontWeight = FontWeight.Bold
                                        )
                                    }
                                }
                            }
                        }
                    }
                }
            },
            confirmButton = {
                Button(
                    onClick = { showImagePicker = false },
                    colors = ButtonDefaults.buttonColors(containerColor = DarkTeal)
                ) {
                    Text("Done")
                }
            }
        )
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .background(TealBackground)
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(32.dp))

        // Image Display Area with Card
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(280.dp)
                .shadow(8.dp, RoundedCornerShape(16.dp)),
            shape = RoundedCornerShape(16.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .clip(RoundedCornerShape(16.dp)),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = selectedDrawableId),
                    contentDescription = "Selected image",
                    modifier = Modifier
                        .fillMaxSize()
                        .blur(
                            radius = if (blurActive) {
                                when (selectedBlurLevel) {
                                    1 -> 5.dp
                                    2 -> 10.dp
                                    3 -> 25.dp
                                    else -> 0.dp
                                }
                            } else {
                                0.dp
                            }
                        ),
                    contentScale = ContentScale.Crop
                )
            }
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Button to open image picker dialog
        Button(
            onClick = { showImagePicker = true },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color.White,
                contentColor = TealBackground
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text("Select Image", fontWeight = FontWeight.SemiBold)
        }

        Spacer(modifier = Modifier.height(24.dp))

        // Blur Selection Title
        Text(
            "Select Blur Amount",
            fontSize = 18.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(start = 8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Blur Options
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 8.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            blurOptions.forEachIndexed { index, option ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { selectedBlurLevel = option.level },
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    RadioButton(
                        selected = selectedBlurLevel == option.level,
                        onClick = { selectedBlurLevel = option.level },
                        colors = RadioButtonDefaults.colors(
                            selectedColor = Color.White,
                            unselectedColor = Color.White.copy(alpha = 0.5f)
                        )
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Text(
                        option.label,
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = Color.White
                    )
                }
            }
        }

        Spacer(modifier = Modifier.weight(1f))

        // Start Button
        Button(
            onClick = { 
                blurActive = true
                onStartBlur(selectedBlurLevel) 
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = DarkTeal
            ),
            shape = RoundedCornerShape(12.dp)
        ) {
            Text(
                "Start",
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.White
            )
        }

        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun BlurSelectionScreenPreview() {
    BlurSelectionScreen()
}
