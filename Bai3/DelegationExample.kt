package com.example.myapplication

// Giả lập một lớp delegate
class DelegationDemo {
    // Cú pháp ủy quyền thuộc tính dùng 'by'
    val lazyValue: String by lazy {
        println("Tính toán giá trị...")
        "Xin chao, day la gia tri khoi tao cham!"
    }
}

fun main() {
    val demo = DelegationDemo()
    println("Lan goi 1:")
    println(demo.lazyValue) // Tính toán lần đầu
    println("Lan goi 2:")
    println(demo.lazyValue) // Lấy luôn giá trị đã có
}