package com.rsk.address

abstract class PostalCode(val postCode: String) {
    abstract fun verify()

    init {
        verify()
    }
}


