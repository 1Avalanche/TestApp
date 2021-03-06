package com.example.testapp.ui.product_screen.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.testapp.domain.entities.ItemTag
import com.example.testapp.domain.entities.TagType
import com.example.testapp.ui.theme.TestAppTheme

@Composable
fun ColorTagsBlock(tagsList: List<Pair<ItemTag?, ItemTag?>>) {
    
    Column(modifier = Modifier
        .wrapContentWidth()
        .wrapContentHeight()) {
        
        tagsList.forEach { pair ->
            Row(modifier = Modifier
                .wrapContentHeight()
                .wrapContentWidth()
                .padding(bottom = 6.dp)) {
                ColorTag(tag = pair.first)
                ColorTag(tag = pair.second)
            }
        }
    }
}

@Composable
fun ColorTag(tag: ItemTag?) {
    tag?.let {
        Card(
            shape = RoundedCornerShape(
                topStart = 0.dp,
                topEnd = 8.dp,
                bottomEnd = 8.dp,
                bottomStart = 8.dp
            ),
            backgroundColor = when (tag.type) {
                        TagType.TOP -> TestAppTheme.colors.tagTop
                        TagType.CATEGORY -> TestAppTheme.colors.tagCategory
                        else -> TestAppTheme.colors.tagColor
            },
            modifier = Modifier
                .wrapContentSize(align = Alignment.Center)
                .padding(end = 7.dp)

        ) {
            Text(
                text = tag.text,
                color = when (tag.type) {
                    TagType.TOP -> TestAppTheme.colors.tagTopText
                    else -> TestAppTheme.colors.mainText
                },
                modifier = Modifier
                    .padding(horizontal = 8.dp, vertical = 4.dp)

            )

        }
    }
}

val list = listOf(
    Pair(ItemTag("?????????? ??", TagType.COLOR_TYPE), ItemTag("?????? - 1", TagType.TOP)),
    Pair(ItemTag("12 - ???????????????????? ??????????????????", TagType.CATEGORY), null)
)

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    TestAppTheme {
        ColorTagsBlock(list)
    }
}

