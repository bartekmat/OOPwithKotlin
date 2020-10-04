package com.rsk

fun main(){
    val logger = ConsoleLogger()
    val postCode = UsZipCode("12345")
    val meeting = Meeting("Review",
                            UkAddress("a house", "a street", "a town", "a county", UkPostalCode("12345")),
                            logger)
    val review = PersonalReview("Review Meeting",
                            Participant(Name("Alice"), ""),
                            listOf(),
                            Room("Room 1"),
                            logger)

    println("Created: ${review.meetingName} and at ${review.locationName}")

    review.closeReview()

    val name = Name("Kevin")
    val participant = Participant(name, "kevin@rsk.com")

    meeting.addParticipant(participant)




}
