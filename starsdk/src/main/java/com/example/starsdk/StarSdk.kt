package com.example.starsdk


import android.util.Log
import androidx.annotation.VisibleForTesting

object StarSdk {

    private const val START_SDK_TAG = "STAR_SDK"
    private const val LIST_SIZE = 10

    @VisibleForTesting
    internal var starList: List<StarInfo> = listOf()

    /**
     * addStarInterface method is running Start sdk.
     * @param type -> big button or small button
     * @param alertCallback -> true If startList size big than 10
     */
    fun addStarInterface(type: StarSizeType, alertCallback: (Boolean) -> Unit) {
        if (starList.size > LIST_SIZE) {
            alertCallback.invoke(true)
            return
        }
        when (type) {
            StarSizeType.B -> {
                clickBigButton()
            }
            StarSizeType.S -> {
                clickSmallButton()
            }
        }
        fingerPrint()
    }

    private fun clickSmallButton() {
        starList = starList +
                StarInfo(
                    StarSizeType.S,
                    StarColorType.randomSmallColor(),
                    StarBrightnessType.randomBrightness()
                )
    }

    private fun fingerPrint() {
        var sumBrightness = 0
        starList.forEach { starInfo ->
            starInfo.brightnessType.takeIf {
                it == StarBrightnessType.Bright
            }?.let { sumBrightness++ }
        }.also {
            Log.i(START_SDK_TAG, starList.toString())
            Log.i(START_SDK_TAG, sumBrightness.toString())
        }
    }

    private fun clickBigButton() {
        starList = starList +
                StarInfo(
                    StarSizeType.B,
                    StarColorType.randomBigColor(),
                    StarBrightnessType.randomBrightness()
                )
    }

}