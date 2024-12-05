package ru.profsoft.testapp.dirol

import ru.profsoft.testapp.base.BaseScreenModel
import javax.inject.Inject

class DirolScreenModel @Inject constructor() : BaseScreenModel<DirolScreenState>(DirolScreenState()) {

    fun setText(text: String) {
        setState {
            currentState.copy(
                text = text,
            )
        }
    }
}
