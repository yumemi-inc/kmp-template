package jp.co.yumemi.di

import android.content.Context
import com.russhwolf.settings.Settings
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import jp.co.yumemi.local.core.AndroidSettingsFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class SettingsModule {
    @Provides
    @Singleton
    fun provideSettingsProvider(
        @ApplicationContext context: Context,
    ): Settings = AndroidSettingsFactory(delegate = context.getSharedPreferences("Default", Context.MODE_PRIVATE)).create()
}
