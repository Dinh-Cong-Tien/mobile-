// Utilities: with, vararg, and augmented assignment examples
fun addToppings(vararg toppings: String) {
    println("Cac thanh phan them vao:")
    for (item in toppings) {
        println("- ${'$'}item")
    }
}

fun main() {
    var a = 10
    var b = 5
    a += b // a = a + b
    a *= 2 // a = a * 2
    println("Gia tri cua a: ${'$'}a")

    val cabin = SquareCabin(6)
    with(cabin) {
        println("Vat lieu xay dung: ${'$'}buildingMaterial")
        println("Dien tich san: ${'$'}{floorArea()}")
        println("Con cho trong khong? ${'$'}{hasRoom()}")
    }

    addToppings("Pho mai", "Xuc xich", "Hanh tay")
}

// Reuse SquareCabin from DwellingSystem
abstract class DwellingLocal(var residents: Int) {
    abstract val buildingMaterial: String
    abstract fun floorArea(): Double
    fun hasRoom(): Boolean = residents < 10
}

class SquareCabin(residents: Int) : DwellingLocal(residents) {
    override val buildingMaterial: String = "Wood"
    override fun floorArea(): Double = 50.0
}
