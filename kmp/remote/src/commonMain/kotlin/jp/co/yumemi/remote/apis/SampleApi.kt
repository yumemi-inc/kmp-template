package jp.co.yumemi.remote.apis

import jp.co.yumemi.remote.core.clients.ApiClient
import jp.co.yumemi.remote.core.infrastructure.HttpResponse
import jp.co.yumemi.remote.core.infrastructure.RequestConfig
import jp.co.yumemi.remote.core.infrastructure.RequestMethod
import jp.co.yumemi.remote.core.infrastructure.wrap
import jp.co.yumemi.remote.models.SampleApiModel

interface SampleApi {
    suspend fun getSample(id: String): HttpResponse<SampleApiModel>
}

class SampleApiImpl(
    private val apiClient: ApiClient
) : SampleApi {
    override suspend fun getSample(id: String): HttpResponse<SampleApiModel> {
        val headers = mutableMapOf<String, String>()
        val query = mutableMapOf<String, List<String>>("id" to listOf(id))
        val requestConfig = RequestConfig<Any?>(
            method = RequestMethod.GET,
            path = "/sample",
            headers = headers,
            query = query,
            body = null
        )
        return apiClient.jsonRequest(
            authNames = listOf(),
            requestConfig = requestConfig,
            body = null
        ).wrap()
    }
}