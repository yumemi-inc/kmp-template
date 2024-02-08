package jp.co.yumemi.core.utils

import androidx.lifecycle.SavedStateHandle
import tech.fika.macaron.core.contract.State

fun <S : State> SavedStateHandle.saveState(state: S) = set(StateKey, state)

fun <S : State> SavedStateHandle.getState(): S? = get(StateKey)

fun SavedStateHandle.hasState(): Boolean = contains(StateKey)

fun SavedStateHandle.onInit(block: () -> Unit) {
    if (!hasState()) block()
}

private const val StateKey = "StateKey"
