package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
import jp.co.yumemi.application.Config
import jp.co.yumemi.remote.apis.SampleApi
import jp.co.yumemi.remote.apis.SampleApiImpl
import jp.co.yumemi.remote.core.clients.ApiClient
import jp.co.yumemi.remote.core.factory.DefaultApiClientFactory

@Module
@InstallIn(SingletonComponent::class)
class ApiModule {
    @Provides
    @Singleton
    fun provideApiClient(
        config: Config,
    ): ApiClient = DefaultApiClientFactory(config).create()

    @Provides
    fun provideSampleApi(
        apiClient: ApiClient,
    ): SampleApi = SampleApiImpl(apiClient = apiClient)
}
