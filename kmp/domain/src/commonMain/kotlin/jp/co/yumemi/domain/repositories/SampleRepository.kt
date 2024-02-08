package jp.co.yumemi.domain.repositories

import jp.co.yumemi.domain.entities.SampleEntity

interface SampleRepository {
    suspend fun getSample(id: String): SampleEntity
}
