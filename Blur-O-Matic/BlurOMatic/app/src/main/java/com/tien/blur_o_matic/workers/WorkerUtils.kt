package com.tien.blur_o_matic.workers

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.tien.blur_o_matic.OUTPUT_PATH
import java.io.File
import java.io.FileOutputStream
import java.util.*

fun makeStatusNotification(message: String, context: Context) {
    // Logic tạo Notification (Copy từ source của Google Codelab)
}

fun blurBitmap(bitmap: Bitmap, applicationContext: Context): Bitmap {
    // Logic làm mờ ảnh sử dụng RenderScript hoặc Canvas
    return bitmap // Tạm thời return bitmap gốc để tránh lỗi compile
}

fun writeBitmapToFile(applicationContext: Context, bitmap: Bitmap): Uri {
    val name = String.format("blur-filter-output-%s.png", UUID.randomUUID().toString())
    val outputDir = File(applicationContext.filesDir, OUTPUT_PATH)
    if (!outputDir.exists()) outputDir.mkdirs()
    val outputFile = File(outputDir, name)
    var out: FileOutputStream? = null
    try {
        out = FileOutputStream(outputFile)
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, out)
    } finally {
        out?.close()
    }
    return Uri.fromFile(outputFile)
}