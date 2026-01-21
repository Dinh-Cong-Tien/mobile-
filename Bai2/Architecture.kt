import kotlin.math.PI

// Abstract class and inheritance demonstration
abstract class Construction() {
    abstract val material: String
    abstract fun calculateSpace(): Double
}

open class BasicHouse(val residents: Int) : Construction() {
    override val material: String = "Gach"
    override fun calculateSpace(): Double {
        return 50.0 // default area
    }
}

class Villa(residents: Int, val floors: Int) : BasicHouse(residents) {
    override val material: String = "Be tong cot thep"
    override fun calculateSpace(): Double {
        return super.calculateSpace() * floors
    }
}

fun main() {
    val myVilla = Villa(5, 3)
    println("Vat lieu: ${'$'}{myVilla.material}, Tong dien tich: ${'$'}{myVilla.calculateSpace()}")
}
