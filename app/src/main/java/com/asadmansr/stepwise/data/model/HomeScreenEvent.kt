package com.asadmansr.stepwise.data.model

sealed interface HomeScreenEvent {
    data object OnStart : HomeScreenEvent
    data class OnAddStep(val step: Int) : HomeScreenEvent
    data class OnStepTapped(val step: Step) : HomeScreenEvent
    data object OnOptionDismissed : HomeScreenEvent
    data class OnStepDelete(val id: Int?) : HomeScreenEvent
}
