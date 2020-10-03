package com.rsk

class Meeting(val meetingName: String, val location: Location = Location("an address")) {

    private val logger = Logger()

    fun addParticipant(participant: Participant) {
        if (verifyParticipant(participant))
            println("Added: ${participant.participantName}")
    }

    private fun verifyParticipant(participant: Participant): Boolean {
        println("Try to verify")
        return true
    }

    protected fun verifyMeeting() {

    }
}



