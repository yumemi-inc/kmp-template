package jp.co.yumemi.domain.usecases

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import jp.co.yumemi.domain.entities.SampleEntity
import jp.co.yumemi.domain.repositories.SampleRepository
import jp.co.yumemi.domain.usecases.SampleExecutor
import jp.co.yumemi.domain.usecases.SampleUseCase
import kotlin.test.Test
import kotlinx.coroutines.test.runTest
import org.kodein.mock.Fake
import org.kodein.mock.Mock
import org.kodein.mock.tests.TestsWithMocks

class SampleUseCaseTest : TestsWithMocks() {
    override fun setUpMocks() = injectMocks(mocker)

    @Mock
    lateinit var sampleRepository: SampleRepository

    @Fake
    lateinit var sampleEntity: SampleEntity
    private val sampleUseCase: SampleUseCase by withMocks { SampleExecutor(sampleRepository = sampleRepository) }

    @Test
    fun testSampleUsecase() = runTest {
        everySuspending { sampleRepository.getSample(isAny()) } returns sampleEntity
        val result = sampleUseCase.execute(arguments = SampleUseCase.Args(""))
        verifyWithSuspend {
            called { sampleRepository.getSample("") }
        }
        result shouldBe sampleEntity
    }

    @Test
    fun testSampleUsecaseFailure() = runTest {
        everySuspending { sampleRepository.getSample(isAny()) } runs { throw Exception() }
        val exception = shouldThrow<Exception> {
            sampleUseCase.execute(arguments = SampleUseCase.Args(""))
        }
        verifyWithSuspend {
            threw<Exception> { sampleRepository.getSample("") }
        }
        exception shouldBe Exception()
    }
}
