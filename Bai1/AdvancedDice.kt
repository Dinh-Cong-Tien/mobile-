class Coin(val label: String) {
    fun flip(): String {
        val side = (1..2).random()
        return if (side == 1) "Mat ngua" else "Mat xap"
    }
}

fun main() {
    val luckyCoin = Coin("Dong xu may man")
    val result = luckyCoin.flip()
    println("Ket qua tung ${luckyCoin.label}: $result")
}
