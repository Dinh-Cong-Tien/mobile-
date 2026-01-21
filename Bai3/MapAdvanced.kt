package com.example.myapplication

fun main() {
    // Sơ đồ tuổi tác
    val peopleAges = mutableMapOf<String, Int>(
        "Fred" to 30,
        "Ann" to 23
    )
    
    // Thêm phần tử mới theo 2 cách
    peopleAges.put("Barbara", 42)
    peopleAges["Joe"] = 51

    // Lặp và sử dụng it.key, it.value
    println("Danh sach tuoi:")
    peopleAges.forEach { print("${it.key} is ${it.value}, ") }
    println()

    // Biến đổi Map thành chuỗi String hoàn chỉnh
    val result = peopleAges.map { "${it.key} is ${it.value}" }.joinToString(", ")
    println("Ket qua Map: $result")
}