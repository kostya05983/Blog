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

#### Пример теста

