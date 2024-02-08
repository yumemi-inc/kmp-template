package jp.co.yumemi.domain.core

fun interface ErrorHandler {
    fun handle(throwable: Throwable): DomainError
}

/**
 * Run handling
 *
 * Extension to run a [block] and map exceptions using an [ErrorHandler] on failure
 */
inline fun <T, R> T.runHandling(handler: ErrorHandler, block: T.() -> R): DomainResult<R> {
    return try {
        DomainResult.Success(block())
    } catch (e: Throwable) {
        DomainResult.Failure(handler.handle(e))
    }
}
