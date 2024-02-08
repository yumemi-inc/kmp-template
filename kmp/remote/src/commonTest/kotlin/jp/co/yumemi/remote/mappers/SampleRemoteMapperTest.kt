package jp.co.yumemi.remote.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.data.models.SampleModel
import jp.co.yumemi.remote.models.SampleApiModel
import kotlin.test.Test
import kotlinx.coroutines.test.runTest
import org.kodein.mock.Fake
import org.kodein.mock.tests.TestsWithMocks

class SampleRemoteMapperTest : TestsWithMocks() {
    override fun setUpMocks() = injectMocks(mocker)

    @Fake
    lateinit var sampleApiModel: SampleApiModel

    @Fake
    lateinit var sampleModel: SampleModel

    @Test
    fun testToDataModel() = runTest {
        repeat(10) {
            SampleRemoteMapper.toDataModel(
                sampleApiModel.copy(
                    id = it.toString()
                )
            ) shouldBe sampleModel.copy(id = "$it")
        }
    }
}
