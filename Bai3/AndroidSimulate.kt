package com.example.myapplication

// Giả lập lớp Bundle của Android
class MockBundle {
    fun getString(key: String): String? = "Value tu $key"
}

class MockIntent {
    val extras: MockBundle? = MockBundle()
}

fun main() {
    val intent: MockIntent? = MockIntent()
    val LETTER = "letter"

    // 1. Lệnh gọi an toàn xâu chuỗi (Safe Call Chaining)
    val letterId = intent?.extras?.getString("letter").toString()
    println("Letter ID: $letterId")

    // 2. Sử dụng 'let' để xử lý biến nullable
    val arguments: MockBundle? = MockBundle()
    var processedId = ""
    
    arguments?.let {
        // 'it' đại diện cho đối tượng arguments không null
        processedId = it.getString(LETTER).toString()
    }
    println("Processed ID: $processedId")
}