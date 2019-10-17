package ru.jetspirit

data class ClassWithBigDataCustom(
    val param1: String,
    val param2: String,
    val test: Int,
    val param3: String,
    val param4: String,
    val listParams: List<OneMoreClass>
)

data class OneMoreClass(
    val param: String,
    val param2: String
)