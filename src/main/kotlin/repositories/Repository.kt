package com.rsk.repositories

import com.rsk.entities.MeetingEntity
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.JsonConfiguration
import kotlinx.serialization.json.JsonDecodingException
import kotlinx.serialization.list
import java.io.File

interface IMeetingRepository : IRepository<MeetingEntity>

interface IRepository<T> {
    fun get(): List<T>
    fun get(id: Int): T
    fun create(entity: T): T
    fun update(entity: T): Boolean
    fun delete(id: Int): Boolean
}

abstract class FileSystemRepository<T>(val filename: String = "database.json") : IRepository<T> {
    init {
        val file = File(filename)
        if (!file.isFile) {
            file.createNewFile()
        }
        println(file.absolutePath)
    }
}

class MeetingFileSystemRepository : FileSystemRepository<MeetingEntity>(), IMeetingRepository {
    private val json = Json(JsonConfiguration.Default)

    private fun meetings(): List<MeetingEntity> {
        //open file
        val data = File(filename).readText()
        //deserialize meetings
        return try {
            json.parse(MeetingEntity.serializer().list, data)
        } catch (exc: JsonDecodingException) {
            listOf()
        }
    }

    override fun get(): List<MeetingEntity> {
        return meetings()
    }

    override fun get(id: Int): MeetingEntity {
        return meetings().first { it.id == id }
    }

    override fun create(entity: MeetingEntity): MeetingEntity {
        val mutableMeetings = meetings().toMutableList()
        val newMeeting = MeetingEntity(
            id = entity.id,
            meetingName = entity.meetingName,
            location = entity.location,
            participants = entity.participants
        )
        mutableMeetings.add(newMeeting)

        //serialize and save
        saveJsonMeetings(mutableMeetings)

        //add a new one
        return entity
    }

    private fun saveJsonMeetings(mutableMeetings: MutableList<MeetingEntity>) {
        val jsonData = json.stringify(MeetingEntity.serializer().list, mutableMeetings)
        File(filename).writeText(jsonData)
    }


    override fun update(entity: MeetingEntity): Boolean {
        //instead of changing the found entity we replace it by taking all except it and then adding the updated version
        val filteredMeetings = getAllExcept(entity.id)

        filteredMeetings.add(entity)

        saveJsonMeetings(filteredMeetings)
        return true
    }

    override fun delete(id: Int): Boolean {
        //here i filter the id off the list and save it again to overwrite
        val allExcept = getAllExcept(id)

        saveJsonMeetings(allExcept)
        return true
    }

    private fun getAllExcept(id: Int): MutableList<MeetingEntity> {
        return meetings().filter { it.id != id }.toMutableList()
    }
}