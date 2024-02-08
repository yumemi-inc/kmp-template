package jp.co.yumemi.core.foundation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import tech.fika.macaron.core.components.Store
import tech.fika.macaron.core.contract.Event
import tech.fika.macaron.core.contract.Intent
import tech.fika.macaron.core.contract.State

data class Contract<I : Intent, S : State, E : Event>(
    val state: S,
    val dispatch: (I) -> Unit = {},
    internal val events: E? = null,
    internal val process: (E) -> Unit = {},
)

@Composable
fun <INTENT : Intent, STATE : State, EVENT : Event> contract(
    store: Store<INTENT, STATE, EVENT>,
): Contract<INTENT, STATE, EVENT> {
    val state by store.state.collectAsState()
    val events by store.event.collectAsState(initial = null)

    return Contract(
        state = state,
        events = events,
        dispatch = { store.dispatch(it) },
        process = { store.process(it) }
    )
}
