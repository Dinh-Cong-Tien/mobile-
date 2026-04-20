package com.example.myapplication

// Mô phỏng coroutine bằng Thread
fun fetchData(): String {
    Thread.sleep(1000) 
    return "Du lieu tu Server"
}

fun processData() {
    val result = fetchData()
    println("Dang xu ly: $result")
}

fun main() {
    // Chạy trong thread riêng
    val thread = Thread {
        processData()
    }
    thread.start()

    Thread.sleep(2000) 
}