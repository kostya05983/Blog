package ru.jetspirit

object Utils {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sumParams(data: TestData): Int {
        return data.paramA + data.paramB
    }
}