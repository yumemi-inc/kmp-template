package jp.co.yumemi.utils

import kotlinx.datetime.Clock
import kotlinx.datetime.Instant

fun interface InstantProvider {
    fun now(): Instant
}

class SystemInstantProvider : InstantProvider {
    override fun now(): Instant = Clock.System.now()
}
