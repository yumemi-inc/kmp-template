package jp.co.yumemi.data.repositories

import jp.co.yumemi.data.sources.SampleLocalDataSource
import jp.co.yumemi.data.sources.SampleRemoteDataSource
import jp.co.yumemi.domain.entities.SampleEntity
import jp.co.yumemi.domain.repositories.SampleRepository
import kotlinx.coroutines.delay

class SampleDataRepository(
    private val sampleLocalDataSource: SampleLocalDataSource,
    private val sampleRemoteDataSource: SampleRemoteDataSource,
) : SampleRepository {
    override suspend fun getSample(id: String): SampleEntity {
        // API
        // return sampleRemoteDataSource.getSample(id = id).let(SampleDataMapper::toEntity)

        // Database
        // return sampleLocalDataSource.getDatabaseSample(id = id).let(SampleDataMapper::toEntity)

        // Settings
        // return sampleLocalDataSource.getSettingsSample()

        // Mock
        delay(2_000L)
        return SampleEntity(id = "1", value = "Hello World")
    }
}