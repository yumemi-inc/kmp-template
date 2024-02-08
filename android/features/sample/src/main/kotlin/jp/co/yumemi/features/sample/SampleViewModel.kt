package jp.co.yumemi.features.sample

import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject
import jp.co.yumemi.core.foundation.StoreViewModel
import jp.co.yumemi.sample.SampleEvent
import jp.co.yumemi.sample.SampleIntent
import jp.co.yumemi.sample.SampleState
import jp.co.yumemi.sample.SampleStateMachine
import tech.fika.macaron.core.components.Store
import tech.fika.macaron.core.factory.StoreFactory
import tech.fika.macaron.logging.Logger
import tech.fika.macaron.logging.LoggingMiddleware
import tech.fika.macaron.statemachine.components.create
import timber.log.Timber

@HiltViewModel
class SampleViewModel @Inject constructor(
    storeFactory: StoreFactory,
    stateMachine: SampleStateMachine,
) : StoreViewModel<SampleIntent, SampleState, SampleEvent>() {
    override val store: Store<SampleIntent, SampleState, SampleEvent> = storeFactory.create(
        initialState = SampleState.Initial,
        stateMachine = stateMachine,
        middlewares = listOf(
            LoggingMiddleware(
                object : Logger {
                    override fun log(level: Logger.Level, tag: String, message: () -> String) {
                        Timber.d(message())
                    }
                },
            ),
        ),
        coroutineContext = viewModelScope.coroutineContext,
    )
}
