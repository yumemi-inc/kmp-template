package jp.co.yumemi.data.sources

import jp.co.yumemi.data.models.SampleModel

interface SampleRemoteDataSource {
    suspend fun getSample(id: String): SampleModel
}