package com.rsk

import com.rsk.logger.Logger


class PersonalReview(
    meetingName: String,
    val employee: Participant,
    val reviewers: List<Participant>,
    override val location: Room,
    logger: Logger
) : Meeting(meetingName, location, logger) {

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