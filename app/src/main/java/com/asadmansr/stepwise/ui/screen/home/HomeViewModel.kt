package com.asadmansr.stepwise.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.asadmansr.stepwise.data.model.HomeScreenEvent
import com.asadmansr.stepwise.data.model.HomeScreenState
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
            todaySteps = 0
        )
    )

    fun getState(): StateFlow<HomeScreenState> {
        return state
    }

    private var todaySteps: Int = 0

    fun handleEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.OnAddStep -> {
                viewModelScope.launch {
                    stepRepository.insertStep(step = event.step)
                }
            }
        }
    }

    private suspend fun emitState() {
        state.emit(
            HomeScreenState(
                todaySteps = todaySteps
            )
        )
    }
}
