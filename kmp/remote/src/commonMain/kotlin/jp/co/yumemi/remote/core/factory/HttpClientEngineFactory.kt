package jp.co.yumemi.remote.core.factory

import io.ktor.client.engine.HttpClientEngine

expect class HttpClientEngineFactory() {
    fun create(): HttpClientEngine
}
