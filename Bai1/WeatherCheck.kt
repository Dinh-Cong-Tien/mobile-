fun main() {
    val temp = 32

    if (temp > 35) {
        println("Troi rat nong")
    } else if (temp >= 20) {
        println("Thoi tiet de chiu")
    } else {
        println("Troi lanh")
    }

    val weatherCode = (1..4).random()
    when (weatherCode) {
        1 -> println("Troi quang dang")
        2 -> println("Co may rai rac")
        3 -> println("Mua nho")
        else -> println("Bao lon hay can than")
    }
}
