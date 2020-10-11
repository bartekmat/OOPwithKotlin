package com.rsk.entities

import kotlinx.serialization.Serializable

@Serializable
class ParticipantEntity(val name: String) {
    override fun toString(): String {
        return "ParticipantEntity(name='$name')"
    }
}
