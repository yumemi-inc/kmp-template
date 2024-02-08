package jp.co.yumemi.local.core

import jp.co.yumemi.data.core.DataException
import jp.co.yumemi.data.core.ExceptionHandler

class LocalExceptionHandler : ExceptionHandler {
    override fun handle(throwable: Throwable): DataException {
        return DataException.Local.Database(throwable.message, throwable)
    }
}
