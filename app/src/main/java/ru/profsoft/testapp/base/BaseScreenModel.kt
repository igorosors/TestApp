package ru.profsoft.testapp.base

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseScreenModel<State : UIState>(
    initialState: State,
) : ScreenModel {

    private val mutableUiState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val uiState = mutableUiState.asStateFlow()

    val currentState: State
        get() = uiState.value

    protected fun setState(reduce: State.() -> State) {
        val newState = currentState.reduce()
        mutableUiState.value = newState
    }
}
