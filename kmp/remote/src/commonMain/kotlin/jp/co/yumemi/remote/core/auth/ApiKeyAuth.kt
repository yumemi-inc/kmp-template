package jp.co.yumemi.remote.core.auth

class ApiKeyAuth(private val location: String, val paramName: String) : jp.co.yumemi.remote.core.auth.Authentication {
    var apiKey: String? = null
    var apiKeyPrefix: String? = null

    override fun apply(query: MutableMap<String, List<String>>, headers: MutableMap<String, String>) {
        val key: String = apiKey ?: return
        val prefix: String? = apiKeyPrefix
        val value: String = if (prefix != null) "$prefix $key" else key
        when (location) {
            "query" -> query[paramName] = listOf(value)
            "header" -> headers[paramName] = value
        }
    }
}
