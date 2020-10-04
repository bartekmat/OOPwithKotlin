package com.rsk


fun main(){
    val meeting = Meeting("Review", UkAddress("a house", "a street", "a town", "a county", "a code"))
    val review = PersonalReview("Review Meeting", Participant(Name("Alice"), ""), listOf(), Room("Room 1"))

    println("Created: ${review.meetingName} and at ${review.locationName}")

    review.closeReview()

    val name = Name("Kevin")
    val participant = Participant(name, "kevin@rsk.com")

    meeting.addParticipant(participant)




}
