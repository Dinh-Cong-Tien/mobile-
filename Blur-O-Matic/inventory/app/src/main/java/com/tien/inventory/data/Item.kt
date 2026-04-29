package com.tien.inventory.data

import com.google.gson.annotations.SerializedName

/**
 * Data class representing an item.
 */
data class Item(
    @SerializedName("id")
    val id: Int = 0,
    @SerializedName("name")
    val name: String,
    @SerializedName("price")
    val price: Double,
    @SerializedName("quantity")
    val quantity: Int
)
