package com.example.myapplication

class GameViewModel {
    private var _currentScrambledWord = "test"
    val currentScrambledWord: String
        get() = _currentScrambledWord

    // Kiểm tra số lượng với toán tử Elvis
    fun checkQuantity(input: Int?) {
        val quantity = input ?: 0
        println("So luong: $quantity")
    }
}

fun main() {
    val viewModel = GameViewModel()
    println("Tu hien tai: ${viewModel.currentScrambledWord}")
    
    viewModel.checkQuantity(null)
    viewModel.checkQuantity(4)
}