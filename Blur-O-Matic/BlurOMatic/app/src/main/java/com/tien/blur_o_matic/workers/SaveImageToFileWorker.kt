package com.tien.blur_o_matic.workers

import android.content.Context
import android.graphics.BitmapFactory
import android.net.Uri
import android.provider.MediaStore
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import androidx.work.workDataOf
import com.tien.blur_o_matic.KEY_IMAGE_URI
import java.text.SimpleDateFormat
import java.util.*

class SaveImageToFileWorker(ctx: Context, params: WorkerParameters) : CoroutineWorker(ctx, params) {
    override suspend fun doWork(): Result {
        val resourceUri = inputData.getString(KEY_IMAGE_URI)
        return try {
            val resolver = applicationContext.contentResolver
            val bitmap = BitmapFactory.decodeStream(resolver.openInputStream(Uri.parse(resourceUri)))
            val imageUrl = MediaStore.Images.Media.insertImage(
                resolver, bitmap, "Blurred Image", "Lưu từ app Blur-O-Matic"
            )
            if (!imageUrl.isNullOrEmpty()) {
                Result.success(workDataOf(KEY_IMAGE_URI to imageUrl))
            } else {
                Result.failure()
            }
        } catch (e: Exception) {
            Result.failure()
        }
    }
}