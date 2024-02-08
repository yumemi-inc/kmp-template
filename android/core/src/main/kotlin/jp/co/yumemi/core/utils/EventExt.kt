package jp.co.yumemi.core.utils

import android.annotation.SuppressLint
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import jp.co.yumemi.core.foundation.Contract
import kotlinx.coroutines.CoroutineScope
import tech.fika.macaron.core.contract.Event

@SuppressLint("ComposableNaming")
@Composable
fun <E : Event> E?.handle(process: (E) -> Unit, block: (E) -> Unit) {
    this?.let {
        LaunchedEffect(it) {
            block(it)
            process(it)
        }
    }
}

@SuppressLint("ComposableNaming")
@Composable
fun <E : Event> Contract<*, *, E>.handleEvents(block: CoroutineScope.(E) -> Unit) {
    events?.let {
        LaunchedEffect(it.hashCode()) {
            block(it)
            process(it)
        }
    }
}
