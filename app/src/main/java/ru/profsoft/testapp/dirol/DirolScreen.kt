package ru.profsoft.testapp.dirol

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.hilt.getScreenModel
import ru.profsoft.testapp.components.SheetField

class DirolScreen : Screen {

    @Composable
    override fun Content() {
        val screenModel = getScreenModel<DirolScreenModel>()
        val state by screenModel.state.collectAsState()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .navigationBarsPadding(),
            verticalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(Color.DarkGray)
                    .statusBarsPadding()
            )

            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "MVI",
                color = Color.Black,
            )

            SheetField(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = state.text,
                onTextChanged = remember { { text -> screenModel.setText(text) } },
            )

            Text(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .background(Color.DarkGray)
                    .clickable(onClick = remember { { screenModel.getData() } })
                    .padding(vertical = 12.dp),
                text = "get data",
                color = Color.White,
                textAlign = TextAlign.Center,
            )
        }
    }
}
