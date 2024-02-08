package jp.co.yumemi.data.core

/**
 * Exception handler
 *
 * Maps throwables to [DataException]s
 */
fun interface ExceptionHandler {
    fun handle(throwable: Throwable): DataException
}

/**
 * Run handling
 *
 * Extension to run a [block] and map exceptions using an [ExceptionHandler] on failure
 */
inline fun <T, R> T.runHandling(handler: ExceptionHandler, block: T.() -> R): R {
    return try {
        block()
    } catch (e: Throwable) {
        throw handler.handle(e)
    }
}
