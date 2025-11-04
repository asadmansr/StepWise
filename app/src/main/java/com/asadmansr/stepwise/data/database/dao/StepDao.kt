package com.asadmansr.stepwise.data.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.asadmansr.stepwise.data.database.entity.StepEntity

@Dao
interface StepDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertStep(stepEntity: StepEntity)

    @Update
    suspend fun updateStep(stepEntity: StepEntity): Int

    @Query("SELECT * from steps WHERE id = :id")
    suspend fun getStepById(id: Int): StepEntity?

    @Query("SELECT * FROM steps")
    suspend fun getAllSteps(): List<StepEntity>

    @Query("DELETE FROM steps WHERE id = :id")
    suspend fun deleteStepById(id: Int): Int

    @Query("DELETE FROM steps")
    suspend fun deleteAllSteps(): Int
}
