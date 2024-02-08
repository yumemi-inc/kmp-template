package jp.co.yumemi.local.core

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.native.NativeSqliteDriver
import jp.co.yumemi.local.core.SqlDriverFactory

class IosSqlDriverFactory : SqlDriverFactory {
    override fun create(schema: SqlSchema, name: String): SqlDriver = NativeSqliteDriver(
        schema = schema,
        name = name,
    )
}
