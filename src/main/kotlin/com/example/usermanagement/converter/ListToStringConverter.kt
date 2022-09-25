package com.example.usermanagement.converter

import java.util.*
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class ListToStringConverter : AttributeConverter<List<String>, String> {
    override fun convertToDatabaseColumn(attribute: List<String>?): String? {
        return if (attribute == null) null else java.lang.String.join(", ", attribute)
    }

    override fun convertToEntityAttribute(dbData: String?): List<String>? {
        return dbData?.split(", ") ?: Collections.emptyList()
    }
}