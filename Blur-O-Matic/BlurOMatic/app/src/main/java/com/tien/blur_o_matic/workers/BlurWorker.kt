package com.tien.blur_o_matic.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.tien.blur_o_matic.KEY_IMAGE_URI

class BlurWorker(ctx: Context, params: WorkerParameters) : CoroutineWorker(ctx, params) {
    override suspend fun doWork(): Result {
        val resourceUri = inputData.getString(KEY_IMAGE_URI)

        // Gọi hàm từ WorkerUtils
        makeStatusNotification("Đang làm mờ ảnh...", applicationContext)

        return try {
            if (resourceUri.isNullOrEmpty()) throw IllegalArgumentException("URI không hợp lệ")

            val resolver = applicationContext.contentResolver
            val bitmap = BitmapFactory.decodeStream(resolver.openInputStream(Uri.parse(resourceUri)))

            // Các hàm này nằm trong file WorkerUtils.kt
            val output = blurBitmap(bitmap, applicationContext)
            val outputUri = writeBitmapToFile(applicationContext, output)

            Result.success(workDataOf(KEY_IMAGE_URI to outputUri.toString()))
        } catch (throwable: Throwable) {
            Result.failure()
        }
    }
}