package com.rsk.entities

class MeetingEntity(val id: Int,
                    val meetingName: String,
                    val location: LocationEntity,
                    val participants: List<ParticipantEntity>){
    override fun toString(): String {
        return "MeetingEntity(id=$id, meetingName='$meetingName', location=$location, participants=$participants)"
    }
}

class ParticipantEntity(val name: String) {
    override fun toString(): String {
        return "ParticipantEntity(name='$name')"
    }
}

class LocationEntity(val roomName: String) {
    override fun toString(): String {
        return "LocationEntity(name='$roomName')"
    }
}
