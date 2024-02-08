package jp.co.yumemi.remote.core.factory

import io.ktor.client.engine.HttpClientEngine
import io.ktor.client.engine.darwin.Darwin

actual class HttpClientEngineFactory {
    actual fun create(): HttpClientEngine = Darwin.create()
}
