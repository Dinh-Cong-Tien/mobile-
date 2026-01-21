// Demonstrate for and while loops over a list
fun main() {
    val colors = listOf("Do", "Xanh", "Vang")

    // for loop
    println("Duyet bang for:")
    for (color in colors) {
        println("Mau: ${'$'}color")
    }

    // while loop with index
    println("\nDuyet bang while:")
    var i = 0
    while (i < colors.size) {
        println("Vi tri ${'$'}i la mau ${'$'}{colors[i]}")
        i++
    }
}
