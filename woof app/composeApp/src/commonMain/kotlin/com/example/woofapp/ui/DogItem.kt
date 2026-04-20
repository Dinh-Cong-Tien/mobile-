package com.example.woofapp.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.woofapp.data.Dog
import coil3.compose.AsyncImage

@Composable
fun DogItem(dog: Dog) {

    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 8.dp, vertical = 4.dp)
            .animateContentSize()
    ) {

        Column(modifier = Modifier.padding(16.dp)) {

            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ) {

                // Dog Image from URL
                if (dog.imageUrl.isNotEmpty()) {
                    AsyncImage(
                        model = dog.imageUrl,
                        contentDescription = "Picture of ${dog.name}",
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                } else {
                    // Fallback placeholder
                    Card(
                        modifier = Modifier
                            .size(64.dp)
                            .clip(CircleShape),
                        colors = CardDefaults.cardColors(
                            containerColor = MaterialTheme.colorScheme.surfaceVariant
                        )
                    ) {
                        Box(
                            modifier = Modifier.fillMaxSize(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text("🐶", style = MaterialTheme.typography.headlineMedium)
                        }
                    }
                }

                Spacer(modifier = Modifier.width(16.dp))

                Column(modifier = Modifier.weight(1f)) {

                    Text(
                        text = dog.name,
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Bold
                    )

                    Text(
                        text = dog.age,
                        style = MaterialTheme.typography.bodyMedium,
                        fontStyle = FontStyle.Italic
                    )

                }

                Button(
                    onClick = { expanded = !expanded },
                    modifier = Modifier.size(40.dp),
                    contentPadding = PaddingValues(0.dp)
                ) {
                    Text(if (expanded) "▲" else "▼", fontSize = MaterialTheme.typography.bodyMedium.fontSize)
                }

            }

            if (expanded) {

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "About ${dog.name}:",
                    style = MaterialTheme.typography.labelMedium,
                    fontWeight = FontWeight.Bold,
                    fontStyle = FontStyle.Italic,
                    modifier = Modifier.padding(bottom = 4.dp)
                )

                Text(
                    text = dog.about,
                    style = MaterialTheme.typography.bodyMedium
                )

            }

        }

    }

}
