package jp.co.yumemi.remote.core.auth

import jp.co.yumemi.remote.core.auth.Authentication

class OAuth : jp.co.yumemi.remote.core.auth.Authentication {
    var accessToken: String? = null

    override fun apply(query: MutableMap<String, List<String>>, headers: MutableMap<String, String>) {
        val token: String = accessToken ?: return
        headers["Authorization"] = "Bearer $token"
    }
}
