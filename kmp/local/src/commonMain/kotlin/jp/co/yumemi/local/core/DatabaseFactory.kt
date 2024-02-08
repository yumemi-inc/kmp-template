package jp.co.yumemi.local.core

import app.cash.sqldelight.Transacter

fun interface DatabaseFactory<T : Transacter> {
    fun create(): T
}
