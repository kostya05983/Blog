package ru.jetspirit

import com.fasterxml.jackson.databind.ObjectMapper
import org.openjdk.jmh.annotations.*

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 2)
@Measurement(iterations = 5, batchSize = 10)
@State(value = Scope.Benchmark)
open class SerializationWithCustomBench {
    private lateinit var test: List<ClassWithBigDataCustom>

    @Setup
    fun setup() {
        test = generateData()
    }

    @Benchmark
    fun serialize() {
        val mapper = ObjectMapper()
        mapper.writeValueAsString(test)
    }

    private fun generateData(): List<ClassWithBigDataCustom> {
        val list = mutableListOf<ClassWithBigDataCustom>()
        repeat(1000) {
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
}

