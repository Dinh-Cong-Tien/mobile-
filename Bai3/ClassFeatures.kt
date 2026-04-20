package com.example.myapplication

class GameSession {
    // Thuộc tính dự phòng 
    private var _score = 0
    val score: Int
        get() = _score

    // Đối tượng đồng hành 
    companion object {
        const val MAX_PLAYERS = 4
        const val CATEGORY = "Puzzle"
    }
}

fun main() {
    // Truy cập hằng số từ companion object mà không cần tạo thực thể
    println("The loai game: ${GameSession.CATEGORY}")
    println("So nguoi choi toi: ${GameSession.MAX_PLAYERS}")

    // Sử dụng 'apply' để cấu hình đối tượng
    val game = GameSession().apply {
        // Thường dùng để khởi tạo cấu hình đối tượng phức tạp
        println("Dang khoi tao game...")
    }
}