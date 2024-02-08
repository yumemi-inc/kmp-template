package jp.co.yumemi.di

import com.russhwolf.settings.Settings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier
import jp.co.yumemi.data.core.ExceptionHandler
import jp.co.yumemi.data.sources.SampleLocalDataSource
import jp.co.yumemi.local.Database
import jp.co.yumemi.local.core.LocalExceptionHandler
import jp.co.yumemi.local.providers.SampleLocalDataProvider
import jp.co.yumemi.remote.core.exception.RemoteExceptionHandler

@Module
@InstallIn(SingletonComponent::class) // 接続確認用. ActivityRetainedComponentに戻す
class LocalModule {
    @Provides
    fun provideLocalExceptionHandler(): LocalExceptionHandler = LocalExceptionHandler()

    @Provides
    fun provideSampleLocalDataSource(
        settings: Settings,
        database: Database,
        exceptionHandler: LocalExceptionHandler,
    ): SampleLocalDataSource = SampleLocalDataProvider(
        settings = settings,
        database = database,
        exceptionHandler = exceptionHandler,
    )
}
