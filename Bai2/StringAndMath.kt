import kotlin.math.PI

fun main() {
    val name = "Android"
    println("Do dai chuoi: ${'$'}{name.length}")

    val number = 10
    val groups = 5
    println("Tong cong: ${'$'}{number * groups} nguoi")

    val radius = 4.0
    val circleArea = PI * radius * radius
    println("Dien tich hinh tron la: ${'$'}circleArea")
}
