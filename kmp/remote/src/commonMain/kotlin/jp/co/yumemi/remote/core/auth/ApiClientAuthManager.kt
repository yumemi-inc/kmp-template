package jp.co.yumemi.remote.core.auth

import jp.co.yumemi.remote.core.clients.ApiClient

class ApiClientAuthManager(private val apiClient: ApiClient) : jp.co.yumemi.remote.core.auth.AuthManager {
    override fun set(accessToken: String) {
        apiClient.setAccessToken(accessToken = accessToken)
    }
}
