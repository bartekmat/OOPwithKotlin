package com.rsk.entities

import com.rsk.repositories.Entity
import kotlinx.serialization.Serializable
@Serializable
class MeetingEntity(
    override val id: Int,
    val meetingName: String,
    val location: LocationEntity,
    val participants: List<ParticipantEntity>): Entity{

    override fun toString(): String {
        return "MeetingEntity(id=$id, meetingName='$meetingName', location=$location, participants=$participants)"
    }
}
@Serializable
class ParticipantEntity(val name: String) {
    override fun toString(): String {
        return "ParticipantEntity(name='$name')"
    }
}
@Serializable
class LocationEntity(val roomName: String) {
    override fun toString(): String {
        return "LocationEntity(name='$roomName')"
    }
}
