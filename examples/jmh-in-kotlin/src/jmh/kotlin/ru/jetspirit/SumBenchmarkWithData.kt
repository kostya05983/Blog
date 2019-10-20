package ru.jetspirit

import org.openjdk.jmh.annotations.*

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 2)
@Measurement(iterations = 5, batchSize = 10)
@State(value = Scope.Benchmark)
class SumBenchmarkWithData {
    private lateinit var test: TestData

    @Setup
    fun setup() {
        test = TestData(2, 4)
    }

    @Benchmark
    fun sum() {
        Utils.sumParams(test)
    }
}