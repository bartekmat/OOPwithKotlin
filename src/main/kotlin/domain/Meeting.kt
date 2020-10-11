package com.rsk.domain

import com.rsk.logger.Logger

open class Meeting(val meetingName: String, open val location: Location, val logger: Logger) {

    open val locationName = ""
    private val _participants = mutableListOf<Participant>()

    val participants: List<Participant>
        get() = _participants


    fun addParticipant(participant: Participant) {
        if (verifyParticipant(participant))
            _participants.add(participant)
            println("Added: ${participant.participantName}")
    }

    private fun verifyParticipant(participant: Participant): Boolean {
        println("Try to verify")
        return true
    }

    protected open fun verifyMeeting() {
        println("Meeting: verify meeting")
    }
}




