package ru.profsoft.testapp.orbit

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import org.orbitmvi.orbit.Container
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container
import javax.inject.Inject

class OrbitScreenModel @Inject constructor() : ScreenModel, ContainerHost<OrbitScreenState, Nothing> {

    override val container: Container<OrbitScreenState, Nothing> =
        screenModelScope.container(initialState = OrbitScreenState())

    fun setText(text: String) = intent {
        reduce { state.copy(text = text) }
    }

    fun blockingSetText(text: String) = blockingIntent {
        reduce { state.copy(blockingText = text) }
    }
}
