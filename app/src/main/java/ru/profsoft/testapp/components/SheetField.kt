package ru.profsoft.testapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun SheetField(
    text: String,
    onTextChanged: (String) -> Unit,
    modifier: Modifier = Modifier,
) {
    BasicTextField(
        modifier = modifier
            .fillMaxWidth()
            .background(Color.LightGray)
            .padding(vertical = 12.dp),
        value = text,
        textStyle = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            color = Color.Black,
        ),
        cursorBrush = SolidColor(Color.Black),
        onValueChange = onTextChanged,
    )
}
