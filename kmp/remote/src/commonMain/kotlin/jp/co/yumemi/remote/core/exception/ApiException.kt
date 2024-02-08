package jp.co.yumemi.remote.core.exception

/**
 * Api exception
 *
 * Wrapper for api [Throwable]s
 */
sealed class ApiException : Throwable() {
    abstract val statusCode: Int
    abstract override val message: String?
    abstract override val cause: Throwable?
}
