package com.example.aip06.ui.dashboard.model

import java.util.Locale

data class HourlySummaryUiModel(
    val hour: Int, // 0..23
    val distanceKm: Double,
    val isPeak: Boolean = false
) {
    val displayHour: String
        get() = String.format(Locale.US, "%02d:00", hour)
}
