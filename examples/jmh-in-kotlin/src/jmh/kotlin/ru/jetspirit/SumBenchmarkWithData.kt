package ru.jetspirit

import org.openjdk.jmh.annotations.*

@BenchmarkMode(Mode.SampleTime)
@Warmup(iterations = 2)
@Measurement(iterations = 5, batchSize = 5)
@State(value = Scope.Benchmark)
open class SumBenchmarkWithData {
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