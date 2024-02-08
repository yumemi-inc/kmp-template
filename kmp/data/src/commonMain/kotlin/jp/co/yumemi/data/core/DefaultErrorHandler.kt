package jp.co.yumemi.data.core

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.core.ErrorHandler

/**
 * Default error handler
 *
 * Default implementation of [ErrorHandler]
 */
class DefaultErrorHandler : ErrorHandler {
    override fun handle(throwable: Throwable): DomainError = when (throwable) {
        is DomainError -> throwable
        is DataException -> when (throwable) {
            is DataException.Remote.Network -> DomainError.Network(throwable)
            is DataException.Remote.Unauthorized -> DomainError.LoginRequired(throwable)
            is DataException.Remote.UnprocessableEntity -> DomainError.Server(throwable)
            is DataException.Remote.MissingField -> DomainError.Server(throwable)
            is DataException.Local.Database -> DomainError.Database(throwable)
            is DataException.Local.MissingField -> DomainError.Database(throwable)
            is DataException.Local.MissingValue -> DomainError.Settings(throwable)
            is DataException.Unknown -> DomainError.Unknown(throwable)
        }
        else -> DomainError.Unknown(throwable)
    }
}
