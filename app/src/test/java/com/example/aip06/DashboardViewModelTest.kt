package com.example.aip06

import com.example.aip06.ui.dashboard.DashboardViewModel
import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertNotNull
import org.junit.Assert.assertTrue
import org.junit.Before
import org.junit.Test

class DashboardViewModelTest {

    private lateinit var viewModel: DashboardViewModel

    @Before
    fun setUp() {
        viewModel = DashboardViewModel()
    }

    @Test
    fun initialState_has24HoursOfDataAndValidTotal() {
        val state = viewModel.uiState.value

        assertFalse(state.isTracking)
        assertEquals(8.0, state.targetDistanceKm, 0.001)
        assertEquals(24, state.hourlySummaries.size)
        assertTrue(state.todayTotalDistanceKm > 0.0)
        assertNotNull(state.peakHour)
        assertEquals(18, state.peakHour) // モックデータでのピーク時間帯は18時
    }

    @Test
    fun toggleTracking_switchesTrackingState() {
        assertFalse(viewModel.uiState.value.isTracking)

        viewModel.toggleTracking()
        assertTrue(viewModel.uiState.value.isTracking)

        viewModel.toggleTracking()
        assertFalse(viewModel.uiState.value.isTracking)
    }
}
