package com.asadmansr.stepwise.data.source

import com.asadmansr.stepwise.data.database.dao.StepDao
import com.asadmansr.stepwise.data.database.entity.StepEntity
import javax.inject.Inject

interface StepSource {
    suspend fun getSteps(): List<StepEntity>
    suspend fun insertStep(date: String, step: Int)
    suspend fun deleteStep(id: Int)
}

class StepDaoSource @Inject constructor(
    private val stepDao: StepDao
) : StepSource {

    override suspend fun getSteps(): List<StepEntity> {
        return stepDao.getAllSteps()
    }

    override suspend fun insertStep(date: String, step: Int) {
        stepDao.insertStep(
            stepEntity = StepEntity(
                date = date,
                steps = step
            )
        )
    }

    override suspend fun deleteStep(id: Int) {
        stepDao.deleteStepById(id)
    }
}
