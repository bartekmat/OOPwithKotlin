package com.rsk

import com.rsk.address.UkPostalAddress
import com.rsk.address.UkPostalCode
import com.rsk.address.UsZipCode
import com.rsk.logger.ConsoleLogger

fun main(){
    val logger = ConsoleLogger()
    val postCode = UsZipCode("12345")
    val meeting = Meeting("Review",
        UkPostalAddress(
            "a house",
            "a street",
            "a town",
            "a county",
            UkPostalCode("12345")
        ),
                            logger)
    val review = PersonalReview("Review Meeting",
                            Participant(Name("Alice"), ""),
                            listOf(),
                            Room("Room 1"),
                            logger)

    println("Created: ${review.meetingName} and at ${review.locationName}")

    review.closeReview()

    var name = Name("Kevin Jones")
    var participant = Participant(name, "kevin@rsk.com")
    meeting.addParticipant(participant)

    name = Name("Alice Smith")
    participant = Participant(name, "alice@rsk.com")
    meeting.addParticipant(participant)

    println("-------------Participants-------------")
    meeting.participants.forEach{
        println(it.name)
    }
    println("-------------Participants-------------")
}
