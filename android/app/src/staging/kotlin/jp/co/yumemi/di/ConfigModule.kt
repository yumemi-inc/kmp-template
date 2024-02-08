package jp.co.yumemi.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.app.BuildConfig
import jp.co.yumemi.application.BuildType
import jp.co.yumemi.application.Config
import jp.co.yumemi.application.Platform

@Module
@InstallIn(SingletonComponent::class)
class ConfigModule {
    @Provides
    fun provideConfig(
        @ApplicationContext context: Context,
    ): Config = Config(
        platform = Platform(context = context),
        buildType = BuildType.Staging,
        isLoggingEnabled = BuildConfig.DEBUG,
    )
}
