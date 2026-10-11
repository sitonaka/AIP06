package com.example.aip06.ui.dashboard

import com.example.aip06.ui.dashboard.model.HourlySummaryUiModel

data class DashboardUiState(
    val isTracking: Boolean = false,
    val todayTotalDistanceKm: Double = 0.0,
    val targetDistanceKm: Double = 8.0,
    val hourlySummaries: List<HourlySummaryUiModel> = emptyList(),
    val peakHour: Int? = null
) {
    val progressRatio: Float
        get() = if (targetDistanceKm > 0) (todayTotalDistanceKm / targetDistanceKm).toFloat().coerceIn(0f, 1f) else 0f

    val progressPercentage: Int
        get() = (progressRatio * 100).toInt()
}
