package com.example.myapplication

// Khai báo một đối tượng 
object DatabaseManager {
    val dbName = "Main_DB"
    fun connect() = println("Dang ket noi $dbName...")
}

fun main() {
    DatabaseManager.connect()

    // Phát hiện và xử lý một ngoại lệ (Exception)
    try {
        val list = listOf(1, 2)
        println(list[5]) 
    } catch (exception: Exception) {
        println("Da xay ra loi: ${exception.message}")
    } finally {
        println("Tien trinh ket thuc.")
    }
}