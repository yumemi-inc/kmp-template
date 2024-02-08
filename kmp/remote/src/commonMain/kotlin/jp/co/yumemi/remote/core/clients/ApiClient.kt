package jp.co.yumemi.remote.core.clients

import io.ktor.client.statement.HttpResponse
import io.ktor.http.Parameters
import io.ktor.http.content.PartData
import jp.co.yumemi.remote.core.infrastructure.RequestConfig

interface ApiClient {
    /**
     * Set the username for the first HTTP basic authentication.
     *
     * @param username Username
     */
    fun setUsername(username: String)

    /**
     * Set the password for the first HTTP basic authentication.
     *
     * @param password Password
     */
    fun setPassword(password: String)

    /**
     * Set the API key value for the first API key authentication.
     *
     * @param apiKey API key
     * @param paramName The name of the API key parameter, or null or set the first key.
     */
    fun setApiKey(apiKey: String, paramName: String?)

    /**
     * Set the API key prefix for the first API key authentication.
     *
     * @param apiKeyPrefix API key prefix
     * @param paramName The name of the API key parameter, or null or set the first key.
     */
    fun setApiKeyPrefix(apiKeyPrefix: String, paramName: String?)

    /**
     * Set the access token for the first OAuth2 authentication.
     *
     * @param accessToken Access token
     */
    fun setAccessToken(accessToken: String)

    /**
     * Set the access token for the first Bearer authentication.
     *
     * @param bearerToken The bearer token.
     */
    fun setBearerToken(bearerToken: String)

    suspend fun <T : Any?> multipartFormRequest(
        requestConfig: RequestConfig<T>,
        body: List<PartData>?,
        authNames: List<String>,
    ): HttpResponse

    suspend fun <T : Any?> urlEncodedFormRequest(
        requestConfig: RequestConfig<T>,
        body: Parameters?,
        authNames: List<String>,
    ): HttpResponse

    suspend fun <T : Any?> jsonRequest(requestConfig: RequestConfig<T>, body: Any?, authNames: List<String>): HttpResponse

    suspend fun <T : Any?> request(requestConfig: RequestConfig<T>, body: Any?, authNames: List<String>): HttpResponse
}
