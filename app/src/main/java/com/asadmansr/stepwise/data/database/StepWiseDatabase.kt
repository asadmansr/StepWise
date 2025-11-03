package com.asadmansr.stepwise.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.asadmansr.stepwise.data.database.dao.StepDao
import com.asadmansr.stepwise.data.database.entity.StepEntity

@Database(
    entities = [StepEntity::class],
    version = 1,
    exportSchema = false
)
abstract class StepWiseDatabase : RoomDatabase() {

    companion object {
        const val DATABASE_NAME = "stepwise_database"
    }

    abstract fun stepDao(): StepDao
}
