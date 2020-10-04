package com.rsk

open class Location

class Room(val roomName: String): Location()

class UkAddress(val firstLine: String,
                val secondLine: String,
                val city: String,
                val county: String,
                val postCode: String): Location()