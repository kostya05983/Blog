package ru.jetspirit

object Utils {

    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun getListOf(): List<String> {
        return listOf()
    }

    fun emptyList(): List<String> {
        return emptyList()
    }

    fun test(data: TestData): Int {
        return data.paramA + data.paramB
    }

}