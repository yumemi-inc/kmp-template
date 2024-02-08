package jp.co.yumemi.local.providers

import jp.co.yumemi.data.core.ExceptionHandler
import jp.co.yumemi.data.models.SampleModel
import jp.co.yumemi.data.sources.SampleLocalDataSource
import jp.co.yumemi.local.Database
import jp.co.yumemi.local.SampleTable
import jp.co.yumemi.local.core.MockSqlDriverFactory
import kotlin.test.BeforeTest
import org.kodein.mock.Fake
import org.kodein.mock.Mock
import org.kodein.mock.tests.TestsWithMocks

class SampleLocalDataProviderTest : TestsWithMocks() {
    override fun setUpMocks() = injectMocks(mocker)

    @Mock
    lateinit var exceptionHandler: ExceptionHandler

    @Fake
    lateinit var sampleModel: SampleModel

    @Fake
    lateinit var sampleTable: SampleTable

    private val sampleDatabase: Database = Database(
        driver = MockSqlDriverFactory().create(Database.Schema, "SampleDatabase"),
    )

    private val sampleLocalDataSource: SampleLocalDataSource by withMocks {
        SampleLocalDataProvider(
            database = sampleDatabase,
            exceptionHandler = exceptionHandler,
        )
    }

    @BeforeTest
    fun setup() {
        sampleDatabase.sampleTableQueries.deleteAll()
        repeat(10) {
            sampleDatabase.sampleTableQueries.insert(sampleTable.copy(id = "$it", value_ = "${it}@test.com"))
        }
    }
}
