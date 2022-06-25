package com.example.starsdk


internal enum class StarBrightnessType(val type: Int) {
    None(0),
    Bright(1),
    NotSoMuch(2);

    companion object {
        private fun valueOf(type: Int): StarBrightnessType =
            values().find { value -> value.type == type } ?: None

        fun randomBrightness(): StarBrightnessType = valueOf((1..2).random())
    }
}

internal enum class StarColorType(val type: Int) {
    None(0),
    Red(1),
    Blue(2),
    Green(3),
    Yellow(4),
    Purple(5),
    Gray(6);

    companion object {
        private fun valueOf(type: Int): StarColorType =
            values().find { value -> value.type == type } ?: None

        fun randomSmallColor(): StarColorType = valueOf((1..3).random())
        fun randomBigColor(): StarColorType = valueOf((4..6).random())
    }
}

enum class StarSizeType {
    B, S
}