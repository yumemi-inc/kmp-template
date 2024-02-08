package jp.co.yumemi.remote.core.factory

import io.ktor.client.HttpClient
import io.ktor.client.plugins.DefaultRequest
import io.ktor.client.request.accept
import io.ktor.client.request.header
import io.ktor.http.ContentType
import io.ktor.http.HttpHeaders
import jp.co.yumemi.application.Config
import jp.co.yumemi.data.core.DataException.*
import jp.co.yumemi.remote.core.clients.ApiClient
import jp.co.yumemi.remote.core.clients.DefaultHttpClient
import jp.co.yumemi.remote.core.ext.installJsonSerializer
import jp.co.yumemi.remote.core.ext.installLogging
import jp.co.yumemi.remote.core.ext.installTimeOutConfig

class DefaultApiClientFactory(
    private val config: Config,
) : ApiClientFactory {
    override fun create(): ApiClient = DefaultHttpClient(
        client = HttpClient(
            engine = HttpClientEngineFactory().create(),
        ) {
            install(DefaultRequest) {
                header(HttpHeaders.ContentType, ContentType.Application.Json.toString())
                header(HttpHeaders.Connection, "close") // to avoid java.io.IOException
                accept(ContentType.Application.Json)
            }
            installJsonSerializer()
            installTimeOutConfig()
            if (config.isLoggingEnabled) {
                installLogging()
            }
        },
    )
}
