package com.example.myapplication

fun main() {
    // Xác định sơ đồ có thể thay đổi
    val inventory = mutableMapOf<String, Int>(
        "Laptop" to 5,
        "Mouse" to 20
    )

    // Đặt giá trị mới vào sơ đồ
    inventory.put("Keyboard", 15)
    inventory["Monitor"] = 10

    // 1. Lặp lại tập hợp bằng forEach
    inventory.forEach { print("${it.key}: ${it.value} cai, ") }
    println()

    // 2. Chuyển đổi bằng map và joinToString
    val stockSummary = inventory.map { "${it.key} còn ${it.value}" }.joinToString(" | ")
    println("Tom tat kho: $stockSummary")

    // 3. Lọc các mục có tên dài hơn 5 ký tự
    val longNames = inventory.filter { it.key.length > 5 }
    println("San pham ten dai: $longNames")
}