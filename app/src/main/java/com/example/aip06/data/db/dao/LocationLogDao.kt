package com.example.aip06.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.aip06.data.db.entity.LocationLogEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface LocationLogDao {
    @Insert
    suspend fun insert(log: LocationLogEntity)

    @Query("SELECT * FROM location_logs ORDER BY timestamp DESC")
    fun getAllLogs(): Flow<List<LocationLogEntity>>

    @Query("DELETE FROM location_logs")
    suspend fun deleteAll()
}
