fun buildFloor(width: Int, floors: Int) {
    repeat(floors) {
        print("|")
        repeat(width) { print("_") }
        println("|")
    }
}

fun main() {
    val width = 8
    val levels = 4
    println("Ban ve toa nha $levels tang:")
    buildFloor(width, levels)
}
