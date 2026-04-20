package com.tien.blur_o_matic.ui

import androidx.lifecycle.ViewModel
import androidx.work.WorkInfo
import com.tien.blur_o_matic.data.WorkManagerBluromaticRepository
import kotlinx.coroutines.flow.Flow

class BlurViewModel(private val bluromaticRepository: WorkManagerBluromaticRepository) : ViewModel() {

    // Lấy trạng thái từ WorkManager để UI biết khi nào đang xử lý
    val outputWorkInfo: Flow<List<WorkInfo>> = bluromaticRepository.outputWorkInfo

    fun applyBlur(blurLevel: Int) {
        bluromaticRepository.applyBlur(blurLevel)
    }
}