import kotlin.math.PI

fun printTags(vararg tags: String) {
    for (tag in tags) {
        print("${'$'}tag ")
    }
    println()
}

class Robot(var battery: Int, val name: String) {
    fun status() = battery > 20
}

fun main() {
    var energy = 100
    energy -= 10 // energy = energy - 10
    energy *= 2  // energy = energy * 2
    println("Nang luong hien tai: ${'$'}energy")

    val myBot = Robot(85, "Alpha")
    with(myBot) {
        println("Ten Robot: ${'$'}name")
        println("Pin: ${'$'}battery")
        println("Dang hoat dong: ${'$'}{status()}")
    }

    val radius = 5.0
    val area = PI * radius * radius
    println("Dien tich hinh tron: ${'$'}area")

    printTags("Kotlin", "Learning", "2026")
}
