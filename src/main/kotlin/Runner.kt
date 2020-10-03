package com.rsk


fun main(){
    val meeting = Meeting()

    println("Created: $meeting")
    val participant = Participant()
    val name = Name()
    name.name = "Kevin"
    participant.name = name
    participant.email = "kevin@rsk.com"

    meeting.addParticipant(participant)
    meeting.meetingName = "Review"



}
