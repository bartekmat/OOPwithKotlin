package com.rsk.repositories

import com.rsk.entities.MeetingEntity
import com.rsk.repositories.serialization.MeetingJsonSerializer

class MeetingFileSystemRepository(serializer: MeetingJsonSerializer) : FileSystemRepository<MeetingEntity>(serializer), IMeetingRepository {
    override fun copyEntity(entity: MeetingEntity, newId: Int): MeetingEntity {
        return entity.copy(id = newId)
    }
}