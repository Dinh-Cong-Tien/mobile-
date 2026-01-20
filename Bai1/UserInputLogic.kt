fun main() {
    println("Nhap tuoi cua ban:")
    val input = readLine()

    if (input != null) {
        val age = input.toIntOrNull()
        if (age == null) {
            println("Du lieu nhap khong hop le")
            return
        }

        if (age >= 0 && age <= 12) {
            println("Ban la tre em")
        } else if (age in 13..19) {
            println("Ban la thieu nien")
        } else {
            println("Ban la nguoi lon")
        }
    } else {
        println("Du lieu nhap khong hop le")
    }
}
