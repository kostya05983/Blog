package ru.jetspirit

import com.fasterxml.jackson.databind.ObjectMapper
import org.openjdk.jmh.annotations.*

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 2)
@Measurement(iterations = 5, batchSize = 10)
@State(value = Scope.Benchmark)
open class SerializationWithCustomBench {

//    @Param
    private lateinit var test: ClassWithBigDataCustom

    @Setup
    fun setup() {
        test = ClassWithBigDataCustom(
            "test", "test", 20, "Test", "test",
            listOf(
                OneMoreClass("test1", "test2"),
                OneMoreClass("test1", "test2"),
                OneMoreClass("test1", "test2"),
                OneMoreClass("test1", "test2"),
                OneMoreClass("test1", "test2")
            )
        )
    }

    @Benchmark
    fun serialize() {
        val mapper = ObjectMapper()
        mapper.writeValueAsBytes(test)
    }

//    private fun generateData(): List<ClassWithBigDataCustom> {
//        val list = mutableListOf<ClassWithBigDataCustom>()
//        repeat(1) {
//            list.add(
//                ClassWithBigDataCustom(
//                    "test", "test", 20, "Test", "test",
//                    listOf(
//                        OneMoreClass("test1", "test2"),
//                        OneMoreClass("test1", "test2"),
//                        OneMoreClass("test1", "test2"),
//                        OneMoreClass("test1", "test2"),
//                        OneMoreClass("test1", "test2")
//                    )
//                )
//            )
//        }
//        return list
//    }
}

