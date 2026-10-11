package com.example.aip06.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.aip06.data.db.dao.HourlySummaryDao
import com.example.aip06.data.db.dao.LocationLogDao
import com.example.aip06.data.db.entity.HourlySummaryEntity
import com.example.aip06.data.db.entity.LocationLogEntity

@Database(
    entities = [LocationLogEntity::class, HourlySummaryEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun locationLogDao(): LocationLogDao
    abstract fun hourlySummaryDao(): HourlySummaryDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "travel_meter_database"
                ).build()
                INSTANCE = instance
                instance
            }
        }
    }
}
