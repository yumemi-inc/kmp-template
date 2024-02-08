package jp.co.yumemi.core.foundation

import androidx.lifecycle.ViewModel
import tech.fika.macaron.core.components.Store
import tech.fika.macaron.core.contract.Event
import tech.fika.macaron.core.contract.Intent
import tech.fika.macaron.core.contract.State

abstract class StoreViewModel<I : Intent, S : State, E : Event> : ViewModel() {
    abstract val store: Store<I, S, E>

    override fun onCleared() {
        super.onCleared()
        store.dispose()
    }
}
