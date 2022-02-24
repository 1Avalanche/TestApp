package com.example.testapp.utils

object PriceUtils {

    fun makePriceString(price: Float) : String {
        val pricePair = price.toString().split(".")
        val rubString = pricePair[0]
        val spacer = " "
        var rub = ""
        if (rubString.length <= 3) rub = rubString
        else {
            var formattedSum = ""
            var sum2 = rubString.reversed()
            for (i in 1 until sum2.length+1) {
                formattedSum += sum2[i-1]
                if (i % 3 == 0) formattedSum += spacer
            }
            rub = formattedSum.reversed()
        }
        return if (pricePair[1] != "0" && pricePair[1] != "00") "$rub,${pricePair[1]}" else rub
    }


}