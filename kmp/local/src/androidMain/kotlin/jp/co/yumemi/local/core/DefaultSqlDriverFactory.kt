package jp.co.yumemi.local.core

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema
import app.cash.sqldelight.driver.android.AndroidSqliteDriver
import jp.co.yumemi.application.Config
import jp.co.yumemi.local.core.SqlDriverFactory

class AndroidSqlDriverFactory(private val config: Config) : SqlDriverFactory {
    override fun create(schema: SqlSchema, name: String): SqlDriver = AndroidSqliteDriver(
        schema = schema,
        context = config.platform.context,
        name = name,
    )
}
