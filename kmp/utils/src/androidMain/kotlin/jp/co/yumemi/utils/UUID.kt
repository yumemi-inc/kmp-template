package jp.co.yumemi.utils

import java.util.UUID
import kotlin.String

actual object UUID {
    actual fun randomUUID(): String = UUID.randomUUID().toString()
}
