package com.asadmansr.stepwise.data.repository

import com.asadmansr.stepwise.data.source.StepSource
import javax.inject.Inject

interface StepRepository {
    suspend fun insertStep(step: Int)
}

class ManageStepRepository @Inject constructor(
    private val stepSource: StepSource
) : StepRepository {

    override suspend fun insertStep(step: Int) {
        stepSource.insertStep(
            date = "0Z",
            step = step
        )
    }
}
