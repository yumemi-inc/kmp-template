package jp.co.yumemi.remote.core.factory

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.okhttp.OkHttp

actual class HttpClientEngineFactory {
    actual fun create(): HttpClientEngine = OkHttp.create()
}
