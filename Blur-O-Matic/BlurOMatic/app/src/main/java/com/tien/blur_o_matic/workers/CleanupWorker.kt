package com.tien.blur_o_matic.workers

import android.content.Context
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.tien.blur_o_matic.OUTPUT_PATH
import java.io.File

class CleanupWorker(ctx: Context, params: WorkerParameters) : CoroutineWorker(ctx, params) {
    override suspend fun doWork(): Result {
        return try {
            val outputDirectory = File(applicationContext.filesDir, OUTPUT_PATH)
            if (outputDirectory.exists()) {
                val entries = outputDirectory.listFiles()
                entries?.forEach { it.delete() }
            }
            Result.success()
        } catch (e: Exception) {
            Result.failure()
        }
    }
}