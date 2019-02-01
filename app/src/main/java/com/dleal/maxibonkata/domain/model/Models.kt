package com.dleal.maxibonkata.domain.model

import kotlin.math.max
import kotlin.math.min

class Developer(
    val name: String,
    maxibonsToGrab: Int
) {
    val maxibonsToGrab: Int = maxibonsToGrab
        get() = max(0, field)
}

class Chat {
    fun sendMessage(message: String) {
        println("##### New slack message #####\n\n$message")
    }
}

class KarumiHQs(private val chat: Chat) {
    private var maxibonsLeft = 10

    fun openFridge(developer: Developer): Int {
        maxibonsLeft -= min(developer.maxibonsToGrab, maxibonsLeft)

        if (maxibonsLeft <= MAXIBON_THRESHOLD) {
            sendMaxibonWarning(developer)
        }

        return maxibonsLeft
    }

    fun openFridge(developerList: List<Developer>): Int {
        developerList.forEach { openFridge(it) }

        return maxibonsLeft
    }

    private fun sendMaxibonWarning(developer: Developer) {
        chat.sendMessage("Hey guys, I'm ${developer.name}, and we need more MAXIBONS!!!\n(ノಠ益ಠ)ノ彡┻━┻")

        refillFridge()
    }

    private fun refillFridge() {
        maxibonsLeft += MAXIBON_REFILL
    }
}

private const val MAXIBON_THRESHOLD = 2
private const val MAXIBON_REFILL = 10