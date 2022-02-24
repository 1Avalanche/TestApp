package com.example.testapp.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.testapp.R

object PhraseUtils {

    @Composable
    fun getReviewCounterSemanticString(count: Int) : String {
        val lastNum = count.toString().last()
        return when (lastNum.digitToInt()) {
            1 -> stringResource(R.string.review2, count.toString())
            in 2..4 -> stringResource(R.string.review3, count.toString())
            else -> stringResource(R.string.review1, count.toString())
        }
    }

    @Composable
    fun getSemanticTextBasedReview(count: Int) : String {
        val lastNum = count.toString().last()
        return if (lastNum == '1') stringResource(R.string.based_on_2, count.toString())
        else stringResource(R.string.based_on_1, count.toString())
    }
}