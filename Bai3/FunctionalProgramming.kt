
package com.example.myapplication

fun main() {
    val cities = listOf("Hanoi", "Hue", "Haiphong", "Danang", "Dalat")

    // Chuỗi các phép toán tập hợp
    val filteredCities = cities.filter { it.startsWith("H", ignoreCase = true) }
        .shuffled() 
        .take(2)    
        .sorted()  

    println("Ket qua loc thanh pho: $filteredCities")

    // Hàm Lambda đơn giản
    val square: (Int) -> Int = { n: Int -> n * n }
    println("Binh phuong cua 4 la: ${square(4)}")
}