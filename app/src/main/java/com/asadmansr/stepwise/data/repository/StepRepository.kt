package com.asadmansr.stepwise.data.repository

import com.asadmansr.stepwise.data.model.Step
import com.asadmansr.stepwise.data.source.StepSource
import javax.inject.Inject

interface StepRepository {
    suspend fun getSteps(): List<Step>
    suspend fun insertStep(step: Int)
    suspend fun deleteStep(id: Int)
}

class ManageStepRepository @Inject constructor(
    private val stepSource: StepSource
) : StepRepository {

    override suspend fun getSteps(): List<Step> {
        return stepSource.getSteps().map {
            Step(
                id = it.id,
                steps = it.steps,
                date = it.date
            )
        }
    }

    override suspend fun insertStep(step: Int) {
        stepSource.insertStep(
            date = "0Z",
            step = step
        )
    }

    override suspend fun deleteStep(id: Int) {
        stepSource.deleteStep(id)
    }
}
