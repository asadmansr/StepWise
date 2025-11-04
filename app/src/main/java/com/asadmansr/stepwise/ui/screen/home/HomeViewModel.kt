package com.asadmansr.stepwise.ui.screen.home

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asadmansr.stepwise.data.model.HomeScreenEvent
import com.asadmansr.stepwise.data.model.HomeScreenState
import com.asadmansr.stepwise.data.model.Step
import com.asadmansr.stepwise.data.repository.StepRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val stepRepository: StepRepository
) : ViewModel() {

    private val state: MutableStateFlow<HomeScreenState> = MutableStateFlow(
        HomeScreenState(
            todaySteps = 0,
            steps = emptyList()
        )
    )

    fun getState(): StateFlow<HomeScreenState> {
        return state
    }

    private var todaySteps: Int = 0
    private var steps: List<Step> = emptyList()
    private var stepSelected: Step? = null

    fun handleEvent(event: HomeScreenEvent) {
        when (event) {

            HomeScreenEvent.OnStart -> {
                viewModelScope.launch {
                    steps = stepRepository.getSteps()
                    emitState()
                }
            }

            is HomeScreenEvent.OnAddStep -> {
                viewModelScope.launch {
                    stepRepository.insertStep(step = event.step)
                }
            }

            is HomeScreenEvent.OnStepTapped -> {
                viewModelScope.launch {
                    stepSelected = event.step
                    emitState()
                }
            }

            HomeScreenEvent.OnOptionDismissed -> {
                viewModelScope.launch {
                    stepSelected = null
                    emitState()
                }
            }

            is HomeScreenEvent.OnStepDelete -> {
                viewModelScope.launch {
                    if (event.id != null) {
                        stepRepository.deleteStep(event.id)
                        steps = stepRepository.getSteps()
                        emitState()
                    }
                }
            }
        }
    }

    private suspend fun emitState() {
        state.emit(
            HomeScreenState(
                stepSelected = stepSelected,
                todaySteps = todaySteps,
                steps = steps
            )
        )
    }
}
