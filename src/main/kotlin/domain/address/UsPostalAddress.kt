package com.rsk.address

class UsPostalAddress(firstLine: String,
                      secondLine: String,
                      city: String,
                      county: String,
                      zipCode: UsZipCode
): PostalAddress(firstLine, secondLine, city, county, zipCode)