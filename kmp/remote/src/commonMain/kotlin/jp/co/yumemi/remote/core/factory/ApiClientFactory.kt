package jp.co.yumemi.remote.core.factory

import io.ktor.client.HttpClient
import jp.co.yumemi.remote.core.clients.ApiClient

/**
 * Http client provider
 *
 * Providers an [HttpClient]
 */
interface ApiClientFactory {
    fun create(): ApiClient
}


