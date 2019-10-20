package ru.jetspirit

import org.openjdk.jmh.annotations.*

@BenchmarkMode(Mode.SampleTime)
@Warmup(iterations = 2)
@Measurement(iterations = 5, batchSize = 5)
open class SumBenchmark {

    @Benchmark
    fun sum() {
        Utils.sum(2, 5)
    }
}