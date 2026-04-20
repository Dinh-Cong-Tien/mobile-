package com.example.woofapp.data

data class Dog(
    val name: String,
    val age: String,
    val about: String,
    val imageRes: String,
    val imageUrl: String = "" // URL to dog image
)