package com.example.myapplication

// Tạo một lớp enum
enum class OrderStatus {
    PENDING, 
    SHIPPING, 
    DELIVERED, 
    CANCELLED
}

fun main() {
    // Truy cập vào một giá trị lớp enum
    val currentStatus = OrderStatus.SHIPPING

    // Kiểm tra các giá trị enum bằng when
    when (currentStatus) {
        OrderStatus.PENDING -> {
            println("Don hang dang cho xu ly")
        }
        OrderStatus.SHIPPING -> {
            println("Don hang dang tren duong giao")
        }
        OrderStatus.DELIVERED -> {
            println("Don hang da giao thanh cong")
        }
        OrderStatus.CANCELLED -> {
            println("Don hang da bi huy")
        }
    }
}