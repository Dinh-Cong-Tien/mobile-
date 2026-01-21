// Demonstrate read-only list and mutable list operations
fun main() {
    // Read-only list
    val scores = listOf(85, 90, 78, 92)
    println("So luong diem: ${'$'}{scores.size}")
    println("Diem dau tien: ${'$'}{scores[0]}")
    println("Danh sach dao nguoc: ${'$'}{scores.reversed()}")

    // Mutable list
    val menu = mutableListOf<String>()
    menu.add("Pho Bo")
    menu.add("Bun Cha")

    // Modify and remove
    menu[1] = "Bun Rieu"
    menu.remove("Pho Bo")

    println("Thuc don hien tai: ${'$'}menu")
}
