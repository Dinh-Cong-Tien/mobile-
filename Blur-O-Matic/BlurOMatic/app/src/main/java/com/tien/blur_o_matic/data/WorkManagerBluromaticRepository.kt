package com.tien.blur_o_matic.data

import android.content.Context
import androidx.lifecycle.asFlow
import androidx.work.*
import com.tien.blur_o_matic.*
import com.tien.blur_o_matic.workers.BlurWorker
import com.tien.blur_o_matic.workers.CleanupWorker
import com.tien.blur_o_matic.workers.SaveImageToFileWorker

class WorkManagerBluromaticRepository(context: Context) {
    private val workManager = WorkManager.getInstance(context)

    // Chuyển đổi LiveData sang Flow để dùng trong Compose
    val outputWorkInfo = workManager.getWorkInfosByTagLiveData(TAG_OUTPUT).asFlow()

    fun applyBlur(blurLevel: Int) {
        // Bắt đầu chuỗi với CleanupWorker
        var continuation = workManager.beginUniqueWork(
            IMAGE_MANIPULATION_WORK_NAME,
            ExistingWorkPolicy.REPLACE,
            OneTimeWorkRequest.from(CleanupWorker::class.java)
        )

        // Thêm các vòng lặp làm mờ
        for (i in 0 until blurLevel) {
            val blurBuilder = OneTimeWorkRequestBuilder<BlurWorker>()
            if (i == 0) {
                // Truyền ảnh cupcake mặc định vào
                blurBuilder.setInputData(workDataOf(KEY_IMAGE_URI to "android.resource://com.tien.blur_o_matic/drawable/android_cupcake"))
            }
            continuation = continuation.then(blurBuilder.build())
        }

        // Bước cuối cùng: Lưu file và gắn Tag để theo dõi trạng thái
        val saveRequest = OneTimeWorkRequestBuilder<SaveImageToFileWorker>()
            .addTag(TAG_OUTPUT)
            .build()

        continuation = continuation.then(saveRequest)
        continuation.enqueue() // Kích hoạt chuỗi
    }
}