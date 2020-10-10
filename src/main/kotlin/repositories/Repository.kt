package com.rsk.repositories

import com.rsk.entities.MeetingEntity
import java.io.File

interface IMeetingRepository : IRepository<MeetingEntity>

interface IRepository<T> {
    fun get() : List<T>
    fun get(id: Int) : T
    fun create(entity: T) : T
    fun update(entity: T) : Boolean
    fun delete(id: Int): Boolean
}

abstract class FileSystemRepository<T> (val filename: String = "database.json") : IRepository<T>{
    init {
        val file = File(filename)
        if (!file.isFile){
            file.createNewFile()
        }
        println(file.absolutePath)
    }
}

class MeetingFileSystemRepository : FileSystemRepository<MeetingEntity>(), IMeetingRepository {
    override fun get(): List<MeetingEntity> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun get(id: Int): MeetingEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun create(entity: MeetingEntity): MeetingEntity {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun update(entity: MeetingEntity): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun delete(id: Int): Boolean {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}