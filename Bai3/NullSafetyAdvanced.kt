package com.example.myapplication

class UserProfile {
    // Khởi tạo trễ
    private lateinit var userName: String 

    fun setupUser(name: String) {
        userName = name
    }

    fun display() {
        if (::userName.isInitialized) {
            println("User: $userName")
        }
    }
}

fun main() {
    var score: Int? = null
    
    // Toán tử Elvis (Cung cấp giá trị mặc định nếu null)
    val finalScore = score ?: 0 
    println("Diem so: $finalScore")

    // Lệnh gọi an toàn và let
    val note: String? = "Hoc tap Kotlin"
    note?.let {
        // Khối này chỉ chạy nếu note không null
        println("Do dai ghi chu: ${it.length}")
    }

    val profile = UserProfile()
    profile.setupUser("Admin")
    profile.display()
}