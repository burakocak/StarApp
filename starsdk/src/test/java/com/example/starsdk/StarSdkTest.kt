package com.example.starsdk

import org.junit.After
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Test

class StarSdkTest {

    @After
    fun clearList() {
        StarSdk.starList = listOf()
    }

    @Test
    fun smallButtonClickTest() {
        val smallButtonType = StarSizeType.S

        StarSdk.addStarInterface(smallButtonType, {})

        assertEquals(smallButtonType, StarSdk.starList[0].sizeType)
    }

    @Test
    fun bigButtonClickTest() {
        val bigButtonType = StarSizeType.B

        StarSdk.addStarInterface(bigButtonType, {})

        assertEquals(bigButtonType, StarSdk.starList[0].sizeType)
    }

    @Test
    fun skyIsFullListTest() {
        for (i in 1.rangeTo(11)) {
            StarSdk.addStarInterface(StarSizeType.B) {
                if (i > 9) assertTrue(it)
            }
        }
        assertTrue(StarSdk.starList.size > 10)
    }

    @Test
    fun randomBigColorTypeTest() {
        val bigColor: StarColorType = StarColorType.randomBigColor()
        val condition =
            bigColor.type == StarColorType.Gray.type
                    || bigColor.type == StarColorType.Yellow.type
                    || bigColor.type == StarColorType.Purple.type
        assertTrue(condition)
        assertNotEquals(bigColor, StarColorType.None.type)
    }

    @Test
    fun randomSmallColorTypeTest() {
        val smallButton: StarColorType = StarColorType.randomSmallColor()
        val condition =
            smallButton.type == StarColorType.Green.type
                    || smallButton.type == StarColorType.Blue.type
                    || smallButton.type == StarColorType.Red.type
        assertTrue(condition)
        assertNotEquals(smallButton, StarColorType.None.type)
    }
}