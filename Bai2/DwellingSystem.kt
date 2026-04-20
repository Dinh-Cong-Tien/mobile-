import kotlin.math.PI

// Abstract dwelling examples: Dwelling, SquareCabin, RoundHut, RoundTower
abstract class Dwelling(var residents: Int) {
    abstract val buildingMaterial: String
    abstract fun floorArea(): Double

    fun hasRoom(): Boolean {
        return residents < 10
    }
}

class SquareCabin(residents: Int) : Dwelling(residents) {
    override val buildingMaterial: String = "Wood"
    override fun floorArea(): Double {
        return 50.0
    }
}

open class RoundHut(residents: Int) : Dwelling(residents) {
    override val buildingMaterial: String = "Straw"
    override fun floorArea(): Double {
        return PI * 10.0 * 10.0
    }
}

class RoundTower(residents: Int, val floors: Int = 2) : RoundHut(residents) {
    override val buildingMaterial: String = "Stone"
    override fun floorArea(): Double {
        return super.floorArea() * floors
    }
}

fun main() {
    val tower = RoundTower(4, 3)
    println("Material: ${'$'}{tower.buildingMaterial}, Area: ${'$'}{tower.floorArea()}")
}
