package com.tien.inventory.data.network

import com.tien.inventory.data.Item
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Path

interface InventoryApiService {
    @GET("items")
    suspend fun getAllItems(): List<Item>

    @GET("items/{id}")
    suspend fun getItem(@Path("id") id: Int): Item

    @POST("items")
    suspend fun insertItem(@Body item: Item): Item

    @PUT("items/{id}")
    suspend fun updateItem(@Path("id") id: Int, @Body item: Item): Item

    @DELETE("items/{id}")
    suspend fun deleteItem(@Path("id") id: Int)
}
