package com.example.aip06.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "hourly_summaries")
data class HourlySummaryEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val date: String, // YYYY-MM-DD
    val hour: Int, // 0..23
    val totalDistance: Float // meters
)
