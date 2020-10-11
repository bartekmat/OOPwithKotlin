package com.rsk.repositories

import com.rsk.entities.MeetingEntity
import java.io.File

interface IMeetingRepository : IRepository<MeetingEntity>

interface IRepository<T> {
    fun get(): List<T>
    fun get(id: Int): T
    fun create(entity: T): T
    fun update(entity: T): Boolean
    fun delete(id: Int): Boolean
}

abstract class FileSystemRepository<T: Entity>(val serializer: IJsonSerializer<T>, val filename: String = "database.json") : IRepository<T> {
    init {
        val file = File(filename)
        if (!file.isFile) {
            file.createNewFile()
        }
        println(file.absolutePath)
    }


    private fun loadEntities(): List<T> {
        //open file
        val data = File(filename).readText()
        //deserialize meetings
        return serializer.read(data)
    }

    override fun get(): List<T> {
        return loadEntities()
    }

    override fun get(id: Int): T {
        return loadEntities().first { it.id == id }
    }

    override fun create(entity: T): T {
        val entities = loadEntities().toMutableList()
        val newEntity = copyEntity(entity, entities.size + 1)
        entities.add(newEntity)

        //serialize and save
        saveEntities(entities)

        //add a new one
        return entity
    }

    private fun saveEntities(entities: MutableList<T>) {
        val jsonData = serializer.write(entities)
        File(filename).writeText(jsonData)
    }


    override fun update(entity: T): Boolean {
        //instead of changing the found entity we replace it by taking all except it and then adding the updated version
        val filteredEntities = getAllExcept(entity.id)

        filteredEntities.add(entity)

        saveEntities(filteredEntities)
        return true
    }

    override fun delete(id: Int): Boolean {
        //here i filter the id off the list and save it again to overwrite
        val allExcept = getAllExcept(id)

        saveEntities(allExcept)
        return true
    }

    private fun getAllExcept(id: Int): MutableList<T> {
        return loadEntities().filter { it.id != id }.toMutableList()
    }

    abstract fun copyEntity(entity: T, newId: Int): T
}

class MeetingFileSystemRepository(serializer: MeetingJsonSerializer) : FileSystemRepository<MeetingEntity>(serializer), IMeetingRepository {
    override fun copyEntity(entity: MeetingEntity, newId: Int): MeetingEntity {
        return MeetingEntity(
            id = newId,
            meetingName = entity.meetingName,
            location = entity.location,
            participants = entity.participants
        )
    }
}

interface Entity {
    val id: Int
}