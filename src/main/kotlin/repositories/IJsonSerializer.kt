package com.rsk.repositories

import com.rsk.entities.MeetingEntity
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonDecodingException
import kotlinx.serialization.list

interface IJsonSerializer<T> {
    fun write(entity: List<T>): String
    fun read(data: String): List<T>
}

class MeetingJsonSerializer : IJsonSerializer<MeetingEntity> {
    private val json = Json(JsonConfiguration.Default)

    override fun write(entity: List<MeetingEntity>): String {
        return json.stringify(MeetingEntity.serializer().list, entity)
    }

    override fun read(data: String): List<MeetingEntity> {
        return try {
            json.parse(MeetingEntity.serializer().list, data)
        } catch (exc: JsonDecodingException) {
            listOf()
        }
    }
}