package jp.co.yumemi.local.core

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import app.cash.sqldelight.driver.native.wrapConnection
import co.touchlab.sqliter.DatabaseConfiguration
import jp.co.yumemi.local.core.SqlDriverFactory

actual class MockSqlDriverFactory : SqlDriverFactory {
    override fun create(schema: SqlSchema, name: String): SqlDriver = NativeSqliteDriver(
        configuration = DatabaseConfiguration(
            name = "database",
            version = schema.version,
            create = { connection ->
                wrapConnection(connection) { schema.create(it) }
            },
            upgrade = { connection, oldVersion, newVersion ->
                wrapConnection(connection) { schema.migrate(it, oldVersion, newVersion) }
            },
            inMemory = true
        )
    )
}
