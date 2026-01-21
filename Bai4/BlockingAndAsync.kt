package com.example.myapplication

fun getStockPrice(): Double {
    Thread.sleep(500)
    return 150.5
}

fun main() {
    // Chạy hàm và chặn luồng hiện tại cho đến khi hoàn tất
    println("Bat dau kiem tra gia chung khoan...")
    val price = getStockPrice()
    println("Gia tri hien tai: $price")

    // Sử dụng Thread để chạy song song
    val thread = Thread {
        val asyncPrice = getStockPrice()
        println("Output nhan duoc tu thread: $asyncPrice")
    }
    thread.start()
    println("Dang doi ket qua khong dong bo...")
    thread.join()
}