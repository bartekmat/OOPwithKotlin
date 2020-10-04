package com.rsk

open class Meeting(val meetingName: String, open val location: Location = Location()) {

    private val logger = Logger()

    open val locationName = ""

    fun addParticipant(participant: Participant) {
        if (verifyParticipant(participant))
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

class PersonalReview(
    meetingName: String,
    val employee: Participant,
    val reviewers: List<Participant>,
    override val location: Room
) : Meeting(meetingName, location) {

    override val locationName
        get() = location.roomName

    fun closeReview() {
        println("Review ended")
        verifyMeeting()
    }

    override fun verifyMeeting() {
        println("PersonalReview: verify meeting")
        super.verifyMeeting()
    }

}



