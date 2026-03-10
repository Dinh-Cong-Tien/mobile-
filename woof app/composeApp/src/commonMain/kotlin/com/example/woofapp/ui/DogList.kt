package com.example.woofapp.ui

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.woofapp.data.dogs
import com.example.woofapp.data.Dog

@Composable
fun DogList(modifier: Modifier = Modifier) {

    LazyColumn(modifier = modifier) {

        items(dogs) { dog ->

            DogItem(dog)

        }

    }

}