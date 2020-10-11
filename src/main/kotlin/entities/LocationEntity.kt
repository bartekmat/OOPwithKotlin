package com.rsk.entities

import kotlinx.serialization.Serializable

@Serializable
class LocationEntity(val roomName: String) {
    override fun toString(): String {
        return "LocationEntity(name='$roomName')"
    }
}