package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.local.Database
import jp.co.yumemi.local.core.SqlDriverFactory
import jp.co.yumemi.local.database.DatabaseFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {
    @Provides
    @Singleton
    fun provideSampleDatabase(
        sqlDriverFactory: SqlDriverFactory,
    ): Database = DatabaseFactory(sqlDriverFactory = sqlDriverFactory).create()
}
