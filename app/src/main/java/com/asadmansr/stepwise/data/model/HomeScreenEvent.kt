package com.asadmansr.stepwise.data.model

sealed interface HomeScreenEvent {
    data class OnAddStep(val step: Int) : HomeScreenEvent
}
