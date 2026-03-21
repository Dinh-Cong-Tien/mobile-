package tien.code.cupcake_app

import tien.code.cupcake_app.getPlatform

class Greeting {
    private val platform = getPlatform()

    fun greet(): String {
        return "Hello, ${platform.name}!"
    }
}