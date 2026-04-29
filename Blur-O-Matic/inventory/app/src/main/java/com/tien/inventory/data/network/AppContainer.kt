package com.tien.inventory.data.network

import com.tien.inventory.data.ItemsRepository
import com.tien.inventory.data.NetworkItemsRepository
import com.tien.inventory.utils.AppConfig
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

/**
 * Dependency Injection container at the application level.
 */
interface AppContainer {
    val itemsRepository: ItemsRepository
}

/**
 * [AppContainer] implementation that provides instance of [NetworkItemsRepository]
 */
class AppDataContainer : AppContainer {
    private val baseUrl = AppConfig.BASE_URL

    /**
     * Use the Retrofit builder to build a retrofit object using a Gson converter
     */
    private val retrofit: Retrofit = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl(baseUrl)
        .build()

    /**
     * Retrofit service object for creating api calls
     */
    private val retrofitService: InventoryApiService by lazy {
        retrofit.create(InventoryApiService::class.java)
    }

    /**
     * DI implementation for [ItemsRepository]
     */
    override val itemsRepository: ItemsRepository by lazy {
        NetworkItemsRepository(retrofitService)
    }
}
