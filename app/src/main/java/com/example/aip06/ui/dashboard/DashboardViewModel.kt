package com.example.aip06.ui.dashboard

import androidx.lifecycle.ViewModel
import com.example.aip06.ui.dashboard.model.HourlySummaryUiModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.util.Locale

class DashboardViewModel : ViewModel() {

    private val _uiState = MutableStateFlow(createMockUiState())
    val uiState: StateFlow<DashboardUiState> = _uiState.asStateFlow()

    fun toggleTracking() {
        _uiState.update { currentState ->
            currentState.copy(isTracking = !currentState.isTracking)
        }
    }

    private fun createMockUiState(): DashboardUiState {
        val mockData = mapOf(
            7 to 0.45,
            8 to 1.85,
            9 to 0.30,
            12 to 0.90,
            13 to 0.25,
            18 to 2.40,
            19 to 1.15,
            20 to 0.80
        )

        val full24Hours = (0..23).map { hour ->
            val dist = mockData[hour] ?: 0.0
            HourlySummaryUiModel(hour = hour, distanceKm = dist)
        }

        val maxDistance = full24Hours.maxOfOrNull { it.distanceKm } ?: 0.0
        val peak = if (maxDistance > 0) full24Hours.firstOrNull { it.distanceKm == maxDistance }?.hour else null

        val updatedList = full24Hours.map { item ->
            item.copy(isPeak = (item.hour == peak && peak != null))
        }

        val totalDistance = updatedList.sumOf { it.distanceKm }

        return DashboardUiState(
            isTracking = false,
            todayTotalDistanceKm = String.format(Locale.US, "%.2f", totalDistance).toDouble(),
            targetDistanceKm = 8.0,
            hourlySummaries = updatedList,
            peakHour = peak
        )
    }
}
