package com.tien.inventory.utils

/**
 * Configuration constants for the application
 */
object AppConfig {
    // Development URL (for Android emulator accessing host machine)
    const val BASE_URL_EMULATOR = "http://10.0.2.2:3000/api/"
    
    // Production URL (for physical devices)
    const val BASE_URL_PRODUCTION = "http://192.168.1.x:3000/api/"
    
    // Change this to switch between emulator and physical device
    // For emulator testing: use BASE_URL_EMULATOR
    // For physical device: update the IP and use BASE_URL_PRODUCTION
    const val BASE_URL = BASE_URL_EMULATOR
}
