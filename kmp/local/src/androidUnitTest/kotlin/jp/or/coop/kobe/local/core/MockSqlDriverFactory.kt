package jp.co.yumemi.local.core

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.jdbc.sqlite.JdbcSqliteDriver
import jp.co.yumemi.local.core.SqlDriverFactory

actual class MockSqlDriverFactory : SqlDriverFactory {
    override fun create(schema: SqlSchema, name: String): SqlDriver = JdbcSqliteDriver(JdbcSqliteDriver.IN_MEMORY).also { schema.create(it) }
}
