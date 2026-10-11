package com.example.aip06.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.aip06.data.db.entity.HourlySummaryEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface HourlySummaryDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertOrUpdate(summary: HourlySummaryEntity)

    @Query("SELECT * FROM hourly_summaries WHERE date = :date ORDER BY hour ASC")
    fun getSummariesByDate(date: String): Flow<List<HourlySummaryEntity>>

    @Query("SELECT * FROM hourly_summaries ORDER BY id DESC")
    fun getAllSummaries(): Flow<List<HourlySummaryEntity>>
}
