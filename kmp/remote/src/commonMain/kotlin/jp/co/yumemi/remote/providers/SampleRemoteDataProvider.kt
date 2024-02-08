package jp.co.yumemi.remote.providers

import jp.co.yumemi.data.core.runHandling
import jp.co.yumemi.data.sources.SampleRemoteDataSource
import jp.co.yumemi.remote.apis.SampleApi
import jp.co.yumemi.remote.core.exception.RemoteExceptionHandler
import jp.co.yumemi.remote.mappers.SampleRemoteMapper

class SampleRemoteDataProvider(
    private val sampleApi: SampleApi,
    private val exceptionHandler: RemoteExceptionHandler,
) : SampleRemoteDataSource {
    override suspend fun getSample(id: String) = runHandling(exceptionHandler) {
        sampleApi.getSample(id).body().let(SampleRemoteMapper::toDataModel)
    }

}