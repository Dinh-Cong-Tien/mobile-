// Demonstrate string properties and templates
fun main() {
    val city = "Da Nang"
    println("Ten thanh pho ${'$'}city co ${'$'}{city.length} ky tu.")

    val price = 50
    val quantity = 3
    println("Don gia: ${'$'}price USD")
    println("Tong cong cho ${'$'}quantity san pham: ${'$'}{price * quantity} USD")
}
