package com.example.woofapp

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.woofapp.ui.DogList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    MaterialTheme {

        Scaffold(

            topBar = {
                TopAppBar(
                    title = {
                        Row(
                            modifier = Modifier.fillMaxWidth(),
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            // Icon chân chó (emoji)
                            Text(
                                text = "🐾",
                                style = MaterialTheme.typography.headlineLarge,
                                modifier = Modifier.padding(end = 12.dp)
                            )

                            // Chữ Woof đậm + to
                            Text(
                                text = "Woof",
                                style = MaterialTheme.typography.headlineMedium.copy(
                                    fontWeight = FontWeight.Bold
                                ),
                                color = MaterialTheme.colorScheme.onSurface
                            )
                        }
                    }
                )
            }

        ) { padding ->

            DogList(
                modifier = Modifier.padding(padding)
            )

        }

    }

}
