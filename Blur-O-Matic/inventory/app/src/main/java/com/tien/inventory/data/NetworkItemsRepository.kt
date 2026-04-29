package com.tien.inventory.data

import com.tien.inventory.data.network.InventoryApiService
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class NetworkItemsRepository(private val inventoryApiService: InventoryApiService) : ItemsRepository {
    override fun getAllItemsStream(): Flow<List<Item>> = flow {
        try {
            val items = inventoryApiService.getAllItems()
            android.util.Log.d("InventoryApp", "Fetched ${items.size} items from server")
            emit(items)
        } catch (e: Exception) {
            android.util.Log.e("InventoryApp", "Error fetching items: ${e.message}", e)
            emit(emptyList()) 
        }
    }

    override fun getItemStream(id: Int): Flow<Item?> = flow {
        try {
            emit(inventoryApiService.getItem(id))
        } catch (e: Exception) {
            emit(null)
        }
    }

    override suspend fun insertItem(item: Item) {
        inventoryApiService.insertItem(item)
    }

    override suspend fun deleteItem(item: Item) {
        inventoryApiService.deleteItem(item.id)
    }

    override suspend fun updateItem(item: Item) {
        inventoryApiService.updateItem(item.id, item)
    }
}
