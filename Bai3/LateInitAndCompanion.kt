package com.example.myapplication

class DetailActivity {
    // Companion object chứa hằng số có thể truy cập từ bên ngoài
    companion object {
        const val LETTER = "letter"
    }

    // Khởi tạo trễ cho biến không null
    private lateinit var currentWord: String

    fun onCreate() {
        currentWord = "Kotlin"
        println("Khoi tao tu: $currentWord")
    }
}

fun main() {
    // Truy cập trực tiếp hằng số mà không cần instance
    println("Hang so tu Activity: ${DetailActivity.LETTER}")
    
    val activity = DetailActivity()
    activity.onCreate()
}