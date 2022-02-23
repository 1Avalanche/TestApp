package com.example.testapp.ui.product_screen.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.R
import com.example.testapp.TestApp
import com.example.testapp.ui.product_screen.ProductPageViewModel
import com.example.testapp.ui.product_screen.model.ProductPageEvent
import com.example.testapp.ui.theme.TestAppTheme

@Composable
fun ProductCharacters(characters: List<Pair<String, String>>, showAllCharacters: Boolean, viewModel: ProductPageViewModel?) {
    Column(modifier = Modifier
        .fillMaxWidth()
        .padding(start = 16.dp, top = 56.dp, end = 16.dp)) {

        Text(text=stringResource(id = R.string.title_characters),
            style = TestAppTheme.typography.h1,
        modifier = Modifier.padding(bottom = 4.dp))

        for (character in characters) {
            Character(character = character)
            if (character != characters.last()) SpacerLine()
        }

        LinkButton(text = if (showAllCharacters) stringResource(id = R.string.button_collapse)
                            else stringResource(id = R.string.button_show_all)
        ) { viewModel?.obtainEvent(ProductPageEvent.ShowAllCharacter) }
    }
}

@Composable
fun Character(character: Pair<String, String>) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(vertical = 12.dp)) {
        Text(text = character.first, style = TestAppTheme.typography.bodyHint,
             modifier =  Modifier.weight(0.5f))
        Text(text = character.second, style = TestAppTheme.typography.body,
            modifier =  Modifier.weight(0.5f))
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewProductCharacters() {
    TestAppTheme {
        ProductCharacters(listOf(Pair("Рельеф", "Структурный"), Pair("Цветовая палитра", "Оранжевый"), Pair("Покрытие", "Матовый"), Pair("Тип клея", "Флизелин")),
            false,
        null)
    }
}