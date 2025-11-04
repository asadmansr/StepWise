package com.asadmansr.stepwise.data.model

data class HomeScreenState(
    val stepSelected: Step? = null,
    val todaySteps: Int,
    val steps: List<Step>
)
