package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import jp.co.yumemi.application.Config
import jp.co.yumemi.data.core.DefaultErrorHandler
import jp.co.yumemi.domain.core.ErrorHandler
import jp.co.yumemi.local.core.AndroidSqlDriverFactory
import jp.co.yumemi.local.core.SqlDriverFactory
import jp.co.yumemi.utils.InstantProvider
import jp.co.yumemi.utils.SystemInstantProvider
import tech.fika.macaron.core.factory.DefaultStoreFactory
import tech.fika.macaron.core.factory.StoreFactory

@Module
@InstallIn(SingletonComponent::class)
class AppModule {
    @Provides
    @Singleton
    fun provideStoreFactory(): StoreFactory = DefaultStoreFactory()

    @Provides
    @Singleton
    fun provideSqlDriverProvider(
        config: Config,
    ): SqlDriverFactory = AndroidSqlDriverFactory(config)

    @Provides
    @Singleton
    fun provideErrorHandler(): ErrorHandler = DefaultErrorHandler()

    @Provides
    @Singleton
    fun provideInstantProvider(): InstantProvider = SystemInstantProvider()
}
