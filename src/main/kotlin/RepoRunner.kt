package com.rsk

import com.rsk.entities.LocationEntity
import com.rsk.entities.MeetingEntity
import com.rsk.entities.ParticipantEntity
import com.rsk.repositories.MeetingFileSystemRepository

fun main(){
    val repository = MeetingFileSystemRepository()
    var participants = listOf(ParticipantEntity("Kevin"), ParticipantEntity("Alice"), ParticipantEntity("Tim"))

    var meeting = MeetingEntity(0, "Review", LocationEntity("Saphire"), participants)
    repository.create(meeting)

    participants = listOf(ParticipantEntity("Simon"), ParticipantEntity("Jess"))
    meeting = MeetingEntity(0, "Lunch", LocationEntity("Starbucks"), participants)
    repository.create(meeting)

    repository.get().forEach { println(it) }
    println()
    repository.delete(2)
    repository.get().forEach { println(it) }
}