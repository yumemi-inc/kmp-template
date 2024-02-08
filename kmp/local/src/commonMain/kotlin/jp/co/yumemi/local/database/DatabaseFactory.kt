package jp.co.yumemi.local.database

import jp.co.yumemi.local.Database
import jp.co.yumemi.local.core.DatabaseFactory
import jp.co.yumemi.local.core.SqlDriverFactory
import jp.co.yumemi.local.local.schema

class DatabaseFactory(
    private val sqlDriverFactory: SqlDriverFactory,
) : DatabaseFactory<Database> {
    override fun create(): Database = Database(
        driver = sqlDriverFactory.create(Database::class.schema, "Database"),
    )
}
