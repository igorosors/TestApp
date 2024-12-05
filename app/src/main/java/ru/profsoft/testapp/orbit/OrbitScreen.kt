package ru.profsoft.testapp.orbit

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.registry.ScreenRegistry
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import org.orbitmvi.orbit.compose.collectAsState
import ru.profsoft.testapp.SharedScreen
import ru.profsoft.testapp.components.SheetField

class OrbitScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<OrbitScreenModel>()
        val state by screenModel.collectAsState()
        val navigator = LocalNavigator.currentOrThrow

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
                .statusBarsPadding(),
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

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clickable(
                        onClick = remember {
                            {
                                val dirolScreen = ScreenRegistry.get(SharedScreen.DirolScreen)
                                navigator.push(dirolScreen)
                            }
                        }
                    )
                    .background(Color.DarkGray)
                    .padding(vertical = 12.dp),
                text = "MVI",
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }
    }
}
