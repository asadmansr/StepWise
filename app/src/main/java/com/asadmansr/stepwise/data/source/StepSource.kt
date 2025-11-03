package com.asadmansr.stepwise.data.source

import com.asadmansr.stepwise.data.database.dao.StepDao
import com.asadmansr.stepwise.data.database.entity.StepEntity
import javax.inject.Inject

interface StepSource {
    suspend fun insertStep(date: String, step: Int)
}

class StepDaoSource @Inject constructor(
    private val stepDao: StepDao
) : StepSource {

    override suspend fun insertStep(date: String, step: Int) {
        stepDao.insertStep(
            stepEntity = StepEntity(
                date = date,
                steps = step
            )
        )
    }
}
