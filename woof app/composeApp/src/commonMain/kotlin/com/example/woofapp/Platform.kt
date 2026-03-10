package com.example.woofapp

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
