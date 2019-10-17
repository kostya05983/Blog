package ru.jetspirit.serializers

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import ru.jetspirit.ClassWithBigDataCustom

/**
 * @author Konstantin Volivach
 */
class ClassWithBigDataSerializer : JsonSerializer<ClassWithBigDataCustom>() {
    override fun serialize(value: ClassWithBigDataCustom, gen: JsonGenerator, serializers: SerializerProvider) {
        gen.writeStartObject()
        gen.writeStringField("param1", value.param1)
        gen.writeStringField("param2", value.param2)
        gen.writeNumberField("test", value.test)
        gen.writeStringField("param3", value.param3)
        gen.writeStringField("param4", value.param4)
        gen.writeArrayFieldStart("listParams")
        value.listParams.forEach {
            gen.writeStartObject()
            gen.writeStringField("param", it.param)
            gen.writeStringField("param2", it.param2)
            gen.writeEndObject()
        }
        gen.writeEndArray()
        gen.writeEndObject()
    }
}