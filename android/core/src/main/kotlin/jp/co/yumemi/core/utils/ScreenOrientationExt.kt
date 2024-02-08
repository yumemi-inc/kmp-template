package jp.co.yumemi.core.utils

import android.annotation.SuppressLint
import android.content.Context
import android.content.ContextWrapper
import android.content.pm.ActivityInfo
import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.DisposableEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext

// 画面の向きを切り替える時に使用するメソッド

@Composable
fun RequestedOrientation() {
    val activity by rememberActivity()
    DisposableEffect(Unit) {
        activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_USER
        onDispose {
            @SuppressLint("SourceLockedOrientationActivity")
            activity?.requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }
}

// NOTE: Dagger Hilt + Fragment の場合 Activity を直接取得できないため再帰的に取得する
// https://github.com/googlecodelabs/android-hilt/issues/7
private val Context.activity: AppCompatActivity?
    get() = when (this) {
        is AppCompatActivity -> this
        is ContextWrapper -> baseContext.activity
        else -> null
    }

@Composable
private fun rememberActivity(
    context: Context = LocalContext.current,
): State<AppCompatActivity?> {
    return rememberUpdatedState(newValue = context.activity)
}

@Composable
fun rememberOrientation(
    configuration: Configuration = LocalConfiguration.current,
): State<Int> {
    return rememberUpdatedState(newValue = configuration.orientation)
}
