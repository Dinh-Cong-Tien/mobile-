class SimpleProduct {
    var price = 100
    fun showPrice() {
        println("Gia san pham la: $price USD")
    }
}

class Smartphone(val brand: String, val model: String) {
    fun getInfo(): String = "Dien thoai $brand phien ban $model"
}

fun main() {
    val myPhone = Smartphone("Samsung", "S24")
    println(myPhone.getInfo())
}
