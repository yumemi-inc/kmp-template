package jp.co.yumemi.local.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.local.mappers.SampleLocalMapper
import jp.co.yumemi.data.models.SampleModel
import jp.co.yumemi.local.SampleTable
import kotlinx.coroutines.test.runTest
import org.kodein.mock.Fake
import org.kodein.mock.tests.TestsWithMocks
import kotlin.test.Test

class SampleLocalMapperTest : TestsWithMocks() {
    override fun setUpMocks() = injectMocks(mocker)

    @Fake
    lateinit var sampleTable: SampleTable

    @Fake
    lateinit var sampleModel: SampleModel

    @Test
    fun testToDataModel() = runTest {
        repeat(10) {
            SampleLocalMapper.toDataModel(sampleTable.copy("$it")) shouldBe sampleModel.copy(id = "$it")
        }
    }

    @Test
    fun testToDbModel() = runTest {
        repeat(10) {
            SampleLocalMapper.toDbModel(sampleModel.copy("$it")) shouldBe sampleTable.copy(id = "$it")
        }
    }
}
