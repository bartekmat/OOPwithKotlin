package com.rsk.address

class UkPostalAddress(firstLine: String,
                      secondLine: String,
                      city: String,
                      county: String,
                      postCode: UkPostalCode
): PostalAddress(firstLine, secondLine, city, county, postCode)

