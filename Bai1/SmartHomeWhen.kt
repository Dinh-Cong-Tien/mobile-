fun main() {
    val mode = 2
    val statusMessage = when (mode) {
        1 -> "Che do Tiet kiem dien"
        2 -> "Che do Hieu suat cao"
        3 -> "Che do Nghi ngoi"
        else -> "Khong xac dinh"
    }

    println("Trang thai he thong: $statusMessage")

    val powerLevel = 75
    when (powerLevel) {
        in 1..20 -> println("Pin yeu")
        in 21..100 -> println("Pin on dinh")
        else -> println("Muc pin ngoai pham vi")
    }
}
