package jp.co.yumemi.domain.core

sealed class DomainResult<out R> {
    data class Success<out T>(val data: T) : DomainResult<T>()
    data class Failure(val error: DomainError) : DomainResult<Nothing>()

    inline fun <T> fold(
        onSuccess: (R) -> T,
        onFailure: (DomainError) -> T,
    ): T = when (this) {
        is Success -> onSuccess(data)
        is Failure -> onFailure(error)
    }

    inline fun <T> nullableFold(
        onSuccess: (R) -> T? = { null },
        onFailure: (DomainError) -> T? = { null },
    ): T? = when (this) {
        is Success -> onSuccess(data)
        is Failure -> onFailure(error)
    }

    inline fun onSuccess(block: (R) -> Unit): DomainResult<R> {
        if (this is Success) block(data)
        return this
    }

    inline fun <T> returnOnSuccess(block: (R) -> T): T? {
        return if (this is Success) block(data) else null
    }

    inline fun onFailure(block: (DomainError) -> Unit): DomainResult<R> {
        if (this is Failure) block(error)
        return this
    }

    inline fun <T> returnOnFailure(block: (DomainError) -> T): T? {
        return if (this is Failure) block(error) else null
    }
}
