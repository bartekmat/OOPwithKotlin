package com.rsk.repositories.serialization

interface IJsonSerializer<T> {
    fun write(entity: List<T>): String
    fun read(data: String): List<T>
}