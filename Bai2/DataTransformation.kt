// Demonstrate simple chaining / transformation of called values
class InputField(var content: Any) {
    fun getText(): Any = content
}

fun main() {
    // Mock a binding that returns a non-string and convert to string
    val mockBinding = InputField(12345)
    val resultString = mockBinding.getText().toString()
    println("Ket qua sau khi xau chuoi lenh goi: ${'$'}resultString")
}
