package jp.co.yumemi.local.core

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.db.SqlSchema

fun interface SqlDriverFactory {
    fun create(schema: SqlSchema, name: String): SqlDriver
}
