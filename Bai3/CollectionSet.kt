package com.example.myapplication

fun main() {
    //tạo Set từ danh sách có các phần tử trùng lặp
    val rowData = listOf(10, 20, 30, 40, 50, 10) 
    val unique = rowData.toSet()
    println("Du lieu duy nhat: $unique")

    //Xác định set chỉ đọc và có thể thay đổi
    val grA = setOf(1, 2, 3)
    val grB = mutableSetOf(3, 4, 5)

    //Phép toán trên nhóm
    val comon = grA.intersect(grB)
    val elements = grA.union(grB)

    println("Phan tu chung: $comon")
    println("Tat ca phan tu: $elements")
}