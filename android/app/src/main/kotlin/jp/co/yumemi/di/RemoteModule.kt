package jp.co.yumemi.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.components.ServiceComponent
import javax.inject.Qualifier
import jp.co.yumemi.data.core.ExceptionHandler
import jp.co.yumemi.data.sources.SampleRemoteDataSource
import jp.co.yumemi.remote.apis.SampleApi
import jp.co.yumemi.remote.core.exception.RemoteExceptionHandler
import jp.co.yumemi.remote.providers.SampleRemoteDataProvider

@Module
@InstallIn(ActivityRetainedComponent::class, ServiceComponent::class)
class RemoteModule {
    @Provides
    fun provideRemoteExceptionHandler(): RemoteExceptionHandler = RemoteExceptionHandler()

    @Provides
    fun provideSampleRemoteDataSource(
        sampleApi: SampleApi,
        exceptionHandler: RemoteExceptionHandler,
    ): SampleRemoteDataSource = SampleRemoteDataProvider(
        sampleApi = sampleApi,
        exceptionHandler = exceptionHandler,
    )
}
