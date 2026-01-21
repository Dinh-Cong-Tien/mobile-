// Demonstrate list utilities: size, reversed, remove, set
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6)
    println("Kich thuoc danh sach: ${'$'}{numbers.size}")
    println("Phan tu dau tien: ${'$'}{numbers[0]}")

    val colors = listOf("red", "blue", "green")
    println("Danh sach dao nguoc: ${'$'}{colors.reversed()}")

    val entrees = mutableListOf<String>()
    entrees.add("spaghetti")
    entrees.add("lasagna")
    entrees[0] = "lasagna" // edit example
    println("Sau khi them va sua: ${'$'}entrees")

    entrees.remove("lasagna")
    println("Sau khi xoa: ${'$'}entrees")
}
