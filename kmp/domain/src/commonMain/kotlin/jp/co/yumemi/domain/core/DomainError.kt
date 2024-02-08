package jp.co.yumemi.domain.core

/**
 * Domain error
 *
 * Wrapper for [Throwable]s
 *
 * [Exception]s should be caught in the domain layer and passed as [DomainError]s to the presentation layer
 */
sealed class DomainError(
    open val throwable: Throwable? = null,
) : Throwable(throwable) {
    data class Network(override val throwable: Throwable? = null) : DomainError(throwable)
    data class Server(override val throwable: Throwable? = null) : DomainError(throwable)
    data class Database(override val throwable: Throwable? = null) : DomainError(throwable)
    data class Settings(override val throwable: Throwable? = null) : DomainError(throwable)
    data class Maintenance(override val throwable: Throwable? = null) : DomainError(throwable)
    data class LoginRequired(override val throwable: Throwable? = null) : DomainError(throwable)
    data class Unknown(override val throwable: Throwable? = null) : DomainError(throwable)

    companion object {
        @Throws(DomainError::class)
        fun throwError(error: DomainError) {
            throw error
        }
    }
}
