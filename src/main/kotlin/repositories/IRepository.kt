package com.rsk.repositories

interface IRepository<T> {
    fun get(): List<T>
    fun get(id: Int): T
    fun create(entity: T): T
    fun update(entity: T): Boolean
    fun delete(id: Int): Boolean
}