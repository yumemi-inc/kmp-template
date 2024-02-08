package jp.co.yumemi.remote.core.exception

import io.ktor.client.network.sockets.ConnectTimeoutException
import io.ktor.client.network.sockets.SocketTimeoutException
import io.ktor.client.plugins.HttpRequestTimeoutException
import jp.co.yumemi.data.core.DataException
import jp.co.yumemi.data.core.ExceptionHandler

class RemoteExceptionHandler : ExceptionHandler {
    override fun handle(throwable: Throwable): DataException {
        val exception = when (throwable) {
            is DataException.Remote -> throwable
            is HttpRequestTimeoutException,
            is ConnectTimeoutException,
            is SocketTimeoutException,
            -> DataException.Remote.Network(throwable.message, throwable)

            else -> DataException.Unknown(throwable.message, throwable)
        }
        return exception
    }
}
