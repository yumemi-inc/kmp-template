package jp.co.yumemi.core.utils

import android.content.Context
import android.content.ContextWrapper
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.fragment.app.Fragment
import jp.co.yumemi.core.primitives.SampleTheme

fun Fragment.composeView(content: @Composable () -> Unit): ComposeView = ComposeView(requireContext()).apply {
    // View の LifecycleOwner が破棄されたときに Composition を破棄してメモリリークを防ぐ
    // https://developer.android.com/jetpack/compose/interop/interop-apis#composition-strategy
    setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)

    setContent {
        SampleTheme {
            content()
        }
    }
}

fun Context.findAncestorActivity(): AppCompatActivity? {
    var current: Context? = this
    while (current is ContextWrapper) {
        if (current is AppCompatActivity) return current
        current = current.baseContext
    }
    return null
}
