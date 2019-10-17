package ru.jetspirit.serializers

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.jetspirit.ClassWithBigDataCustom

class ClassWithBigDataSerializer : JsonSerializer<ClassWithBigDataCustom>() {
    override fun serialize(value: ClassWithBigDataCustom, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.write
    }
}