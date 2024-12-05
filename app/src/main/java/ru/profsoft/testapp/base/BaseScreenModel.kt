package ru.profsoft.testapp.base

import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

abstract class BaseScreenModel<State : UIState>(
    initialState: State,
) : ScreenModel {

    private val mutableUIState: MutableStateFlow<State> = MutableStateFlow(initialState)
    val state = mutableUIState.asStateFlow()

    protected val currentState: State
        get() = state.value

    protected fun setState(transform: (State) -> State) {
        mutableUIState.update { state ->
            transform(state)
        }
    }
}
