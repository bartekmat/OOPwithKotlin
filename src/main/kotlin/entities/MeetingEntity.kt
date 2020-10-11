package com.rsk.entities

import kotlinx.serialization.Serializable

@Serializable
data class MeetingEntity(
    override val id: Int,
    val meetingName: String,
    val location: LocationEntity,
    val participants: List<ParticipantEntity>
) : Entity

