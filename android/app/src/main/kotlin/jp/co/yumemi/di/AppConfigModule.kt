package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.core.utils.AppConfig
import jp.co.yumemi.app.BuildConfig

@Module
@InstallIn(SingletonComponent::class)
class AppConfigModule {
    @Provides
    fun provideAppConfig(
    ): AppConfig = AppConfig(
        debug = BuildConfig.DEBUG,
        applicationId = BuildConfig.APPLICATION_ID,
        buildType = BuildConfig.BUILD_TYPE,
        flavor = BuildConfig.FLAVOR,
        versionCode = BuildConfig.VERSION_CODE,
        versionName = BuildConfig.VERSION_NAME,
    )
}
