package jp.co.yumemi.features.sample

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import jp.co.yumemi.domain.core.ErrorHandler
import jp.co.yumemi.domain.usecases.SampleUseCase
import jp.co.yumemi.sample.SampleStateMachine

@Module
@InstallIn(ActivityRetainedComponent::class)
class CoopTouchRoomDetailsModule {
    @Provides
    fun provideSampleStateMachine(
        sampleUseCase: SampleUseCase,
        errorHandler: ErrorHandler,
    ): SampleStateMachine = SampleStateMachine(
        sampleUseCase = sampleUseCase,
        errorHandler = errorHandler,
    )
}
