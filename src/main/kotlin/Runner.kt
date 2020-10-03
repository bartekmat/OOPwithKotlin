package com.rsk


fun main(){
    val meeting = Meeting("Review", Location("any address"))

    println("Created: ${meeting.meetingName} and at ${meeting.location}")
    val name = Name("Kevin")
    val participant = Participant(name, "kevin@rsk.com")

    meeting.addParticipant(participant)




}
