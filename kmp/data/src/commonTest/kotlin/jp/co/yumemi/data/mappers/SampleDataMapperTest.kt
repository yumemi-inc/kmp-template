package jp.co.yumemi.data.mappers

import io.kotest.matchers.shouldBe
import jp.co.yumemi.data.models.SampleModel
import jp.co.yumemi.domain.entities.SampleEntity
import kotlin.test.Test
import org.kodein.mock.Fake
import org.kodein.mock.tests.TestsWithMocks

class SampleDataMapperTest : TestsWithMocks() {
    override fun setUpMocks() = injectMocks(mocker)

    @Fake
    lateinit var entity: SampleEntity

    @Fake
    lateinit var model: SampleModel

    @Test
    fun testToEntity() {
        repeat(10) {
            SampleDataMapper.toEntity(model = model.copy(id = "$it")) shouldBe entity.copy(id = "$it")
        }
    }
}
