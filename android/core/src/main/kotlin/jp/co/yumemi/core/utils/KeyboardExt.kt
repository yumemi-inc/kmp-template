package jp.co.yumemi.core.utils

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.ime
import androidx.compose.foundation.layout.imeAnimationSource
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalDensity

enum class KeyboardState(val isKeyboardVisible: Boolean) {
    Opened(isKeyboardVisible = true),
    Closed(isKeyboardVisible = false),
}

@Composable
fun rememberKeyboardState(): State<KeyboardState> {
    val isImeVisible = if (WindowInsets.ime.getBottom(LocalDensity.current) > 0) {
        KeyboardState.Opened
    } else {
        KeyboardState.Closed
    }
    return rememberUpdatedState(isImeVisible)
}
