package com.dleal.maxibonkata

import com.dleal.maxibonkata.domain.model.Chat
import com.dleal.maxibonkata.domain.model.Developer
import com.dleal.maxibonkata.domain.model.KarumiHQs
import io.kotlintest.properties.forAll
import io.kotlintest.specs.ShouldSpec

class KarumiHQTest : ShouldSpec({
    "Developers" {
        should("Always grab a positive number of maxibons") {
            forAll { numberOfMaxibons: Int ->
                val developer = Developer("name", numberOfMaxibons)
                developer.maxibonsToGrab >= 0
            }
        }

        should("Assign properly the name of the developer") {
            forAll { name: String ->
                val developer = Developer(name, 0)
                developer.name == name
            }
        }

        should("Have always more than two maxibons in fridge") {
            forAll { name: String, numberOfMaxibons: Int ->
                val developer = Developer(name, numberOfMaxibons)
                val chat = Chat()
                val karumiHQ = KarumiHQs(chat)

                karumiHQ.openFridge(developer) > 2
            }
        }
    }
})