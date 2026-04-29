package com.tien.inventory

import android.app.Application
import com.tien.inventory.data.network.AppContainer
import com.tien.inventory.data.network.AppDataContainer

class InventoryApplication : Application() {

    /**
     * AppContainer instance used by the rest of multiple classes to obtain dependencies
     */
    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer()
    }
}
