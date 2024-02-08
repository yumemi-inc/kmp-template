package jp.co.yumemi.core.primitives

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider

/**
 * フルカスタムデザインシステム
 * https://developer.android.com/jetpack/compose/themes/custom
 */
object SampleTheme {
    val colors: SampleColors
        @Composable
        get() = LocalCustomColors.current

    val typography: SampleTypography
        @Composable
        get() = LocalCustomTypography.current
}

@Composable
fun SampleTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalCustomColors provides if (darkTheme) {
            SampleDarkColors
        } else {
            SampleLightColors
        },
        LocalCustomTypography provides CustomTypography
    ) {
        MaterialTheme(
            content = content
        )
    }
}
