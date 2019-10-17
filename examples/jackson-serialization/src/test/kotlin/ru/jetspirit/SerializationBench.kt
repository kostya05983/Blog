package ru.jetspirit

import com.fasterxml.jackson.databind.ObjectMapper
import org.junit.jupiter.api.Test

class SerializationBench {

    companion object {
        const val ITERATIONS = 10000
    }

    private fun generateData(): List<ClassWithBigDataCustom> {
        val list = mutableListOf<ClassWithBigDataCustom>()
        repeat(ITERATIONS) {
            list.add(
                ClassWithBigDataCustom(
                    "test", "test", 20, "Test", "test",
                    listOf(
                        OneMoreClass("test1", "test2"),
                        OneMoreClass("test1", "test2"),
                        OneMoreClass("test1", "test2"),
                        OneMoreClass("test1", "test2"),
                        OneMoreClass("test1", "test2")
                    )
                )
            )
        }
        return list
    }

    private fun generateJustData(): List<ClassWithBigData> {
        val list = mutableListOf<ClassWithBigData>()
        repeat(ITERATIONS) {
            list.add(
                ClassWithBigData(
                    "test", "test", 20, "Test", "test",
                    listOf(
                        OneMoreClass("test1", "test2"),
                        OneMoreClass("test1", "test2"),
                        OneMoreClass("test1", "test2"),
                        OneMoreClass("test1", "test2"),
                        OneMoreClass("test1", "test2")
                    )
                )
            )
        }
        return list
    }

    @Test
    fun test() {
        val list = generateData()
        val mapper = ObjectMapper()
        val start = System.currentTimeMillis()
        for (i in 0 until ITERATIONS) {
            mapper.writeValueAsBytes(list)
        }
        println("Time in ms ${System.currentTimeMillis() - start}")
    }

    @Test
    fun testWithoutCustom() {
        val list = generateJustData()
        val mapper = ObjectMapper()
        val start = System.currentTimeMillis()
        for (i in 0 until ITERATIONS) {
            mapper.writeValueAsBytes(list)
        }
        println("Time in ms ${System.currentTimeMillis() - start}")
    }
}