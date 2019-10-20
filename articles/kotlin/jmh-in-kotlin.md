### Микробенчмаркинг с jmh in Kotlin

Захотелось осветить тему для коллег с микробенчмаркингом в kotlin.

Jmh - Java Microbenchmark Harness, библиотека для тестирования производительности вашего java кода.

Перед тем, как запустить jmh ваша программа должна быть скомпилена в байт код,
но благо для всего этого уже есть плагин.

#### Подключение 

Сконфигурим наш build.gradle следующим образом:

```groovy
plugins {
    id 'org.jetbrains.kotlin.jvm' version '1.3.50'
    id "me.champeau.gradle.jmh" version "0.4.8"
}

repositories {
    mavenCentral()
}
dependencies {
    implementation "org.jetbrains.kotlin:kotlin-stdlib"

    jmh 'org.openjdk.jmh:jmh-core:1.20'
    jmh 'org.openjdk.jmh:jmh-generator-annprocess:1.20'
}
```
В секции с плагинами подключаем: 
```
id "me.champeau.gradle.jmh" version "0.4.8"
```
Ссылка на github https://github.com/melix/jmh-gradle-plugin

#### Утилитный класс над которым будет производиться бенчмаркинг
Возьмем простой класс с функциями суммирования для примера:
```kotlin
object Utils {
    fun sum(a: Int, b: Int): Int {
        return a + b
    }

    fun sumParams(data: TestData): Int {
        return data.paramA + data.paramB
    }
}
```

#### Пример простого бенчмарка
Самый простой бенч на jmh будет выглядить следующим образом:
```kotlin
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
```

#### Как разделить данные между процессами
Чаще всего возникает потребность в приготовленных данных для бенчмаркинга, но чтобы не тратить время каждый раз на приготовление,
а засекать только время выполнения вашей функции, можно проинициализировать данные в функции помеченной аннотацией @Setup, эта функция будет выполняться
перед стартом бенчмарка. Но кроме этого вам также пронадобиться пометить ваш класс для бенчмаркинга аннотацией @State, чтобы сказать jmh, как вы собираетесь разделять
данные в вашем бенчмарке.

State может быть следующим:
* Benchmark - данные будут разделяться между всеми рабочими потоками. Данные будут проинициализированны только одним рабочим потоком. То есть функции помеченные
 Setup и TearDown будет вызвана один раз.
 
 * Group - данные будут разделены между потоками в одной группе. То есть функции помеченные @Setup и @TearDown будут вызванны одним потоком из группы.
 
 * Thread - данные будут уникальны для каждого потока.

В итоге наш пример преобразуется в следующий:
```kotlin
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
```

#### FAQ

//Проблемы с очисткой кода
./gradlew --no-daemon clean jmh

