package ru.profsoft.testapp.dirol

import cafe.adriel.voyager.core.model.screenModelScope
import kotlinx.coroutines.launch
import ru.profsoft.testapp.ApiService
import ru.profsoft.testapp.base.BaseScreenModel
import javax.inject.Inject

class DirolScreenModel @Inject constructor(
    private val apiService: ApiService,
) : BaseScreenModel<DirolScreenState>(DirolScreenState()) {

    fun setText(text: String) {
        setState { state ->
            state.copy(text = text)
        }
    }

    fun getData() {
        screenModelScope.launch {
            runCatching {
                apiService.getTest()
            }
        }
    }
}
