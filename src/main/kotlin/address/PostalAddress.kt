package com.rsk.address

import com.rsk.Location

abstract class PostalAddress(val firstLine: String,
                             val secondLine: String,
                             val city: String,
                             val county: String,
                             val postCode: PostalCode
) : Location()



