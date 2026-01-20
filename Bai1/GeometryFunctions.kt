fun greetUser() {
    println("He thong tinh toan hinh hoc xin chao!")
}

fun drawLine(symbol: String, length: Int) {
    repeat(length) { print(symbol) }
    println()
}

fun getRandomRadius(): Int = (1..10).random()

fun main() {
    greetUser()
    drawLine("*", 15)
    val r = getRandomRadius()
    println("Ban kinh ngau nhien duoc chon la: $r")
}
