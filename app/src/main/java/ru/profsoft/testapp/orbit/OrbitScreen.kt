package ru.profsoft.testapp.orbit

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import org.orbitmvi.orbit.compose.collectAsState
import ru.profsoft.testapp.components.SheetField

class OrbitScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<OrbitScreenModel>()
        val state by screenModel.collectAsState()

        Column(
            modifier = Modifier.statusBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Text(
                text = "Not blocking field",
                color = Color.Black,
            )

            SheetField(
                text = state.text,
                onTextChanged = remember { { text -> screenModel.setText(text) } },
            )

            Text(
                text = "Blocking field",
                color = Color.Black,
            )

            SheetField(
                text = state.blockingText,
                onTextChanged = remember { { text -> screenModel.blockingSetText(text) } },
            )
        }
    }
}
