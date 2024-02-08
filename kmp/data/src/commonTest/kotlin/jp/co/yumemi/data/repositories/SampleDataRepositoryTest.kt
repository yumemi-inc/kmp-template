package jp.co.yumemi.data.repositories

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import jp.co.yumemi.data.models.SampleModel
import jp.co.yumemi.data.sources.SampleLocalDataSource
import jp.co.yumemi.data.sources.SampleRemoteDataSource
import jp.co.yumemi.domain.entities.SampleEntity
import jp.co.yumemi.domain.repositories.SampleRepository
import kotlin.test.Test
import kotlinx.coroutines.test.runTest
import org.kodein.mock.Fake
import org.kodein.mock.Mock
import org.kodein.mock.tests.TestsWithMocks

class SampleDataRepositoryTest : TestsWithMocks() {
    override fun setUpMocks() = injectMocks(mocker)

    @Mock
    lateinit var sampleRemoteDataSource: SampleRemoteDataSource

    @Mock
    lateinit var sampleLocalDataSource: SampleLocalDataSource

    @Fake
    lateinit var sampleModel: SampleModel

    @Fake
    lateinit var sampleEntity: SampleEntity

    private val sampleDataRepository: SampleRepository by withMocks {
        SampleDataRepository(
            sampleRemoteDataSource = sampleRemoteDataSource,
            sampleLocalDataSource = sampleLocalDataSource
        )
    }

    @Test
    fun testLocalGetSamples() = runTest {
        everySuspending { sampleLocalDataSource.getDatabaseSample(isAny()) } returns sampleModel
        val result = sampleDataRepository.getSample("")
        verifyWithSuspend(exhaustive = true) {
            called { sampleLocalDataSource.getDatabaseSample("") }
        }
        result shouldBe sampleEntity
    }
}
