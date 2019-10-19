package ru.jetspirit

import org.openjdk.jmh.annotations.*

@BenchmarkMode(Mode.AverageTime)
@Warmup(iterations = 2)
@Measurement(iterations = 5, batchSize = 10)
open class SumBenchmark {

    @Benchmark
    fun sum() {
        Utils.sum(2, 5)
    }
}