package jp.co.yumemi.core.primitives

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color

@Immutable
data class SampleColors(
    val primary: Color,
    val primaryVariant: Color,
    val background: Color,
    val surface: Color,
    val error: Color,
    val onPrimary: Color,
    val onBackground: Color,
    val onSurface: Color,
    val onError: Color,
)

// CompositionLocal
val LocalCustomColors = staticCompositionLocalOf {
    SampleColors(
        primary = Color.Unspecified,
        primaryVariant = Color.Unspecified,
        background = Color.Unspecified,
        surface = Color.Unspecified,
        error = Color.Unspecified,
        onPrimary = Color.Unspecified,
        onBackground = Color.Unspecified,
        onSurface = Color.Unspecified,
        onError = Color.Unspecified,
    )
}

// ライトテーマ
val SampleLightColors = SampleColors(
    primary = ColorDefinitions.Blue,
    primaryVariant = ColorDefinitions.DarkBlue,
    background = ColorDefinitions.White,
    surface = ColorDefinitions.LightGray,
    error = ColorDefinitions.Red,
    onPrimary = ColorDefinitions.White,
    onBackground = ColorDefinitions.Black,
    onSurface = ColorDefinitions.Black,
    onError = ColorDefinitions.Black,
)

// ダークテーマ
val SampleDarkColors = SampleColors(
    primary = ColorDefinitions.Blue,
    primaryVariant = ColorDefinitions.DarkBlue,
    background = ColorDefinitions.DarkGray,
    surface = ColorDefinitions.Black,
    error = ColorDefinitions.DarkRed,
    onPrimary = ColorDefinitions.White,
    onBackground = ColorDefinitions.White,
    onSurface = ColorDefinitions.White,
    onError = ColorDefinitions.White,
)

val Color.a70 get() = this.copy(alpha = 0.7F)

/**
 * 共用色定義
 */
internal object ColorDefinitions {
    val Blue = Color(0xFF15539A)
    val DarkBlue = Color(0xFF195179)
    val White = Color(0xFFFBFBFB)
    val DarkGray = Color(0xFF1D2125)
    val LightGray = Color(0xFFDEE3EA)
    val Black = Color(0xFF0F0F0F)
    val Red = Color(0xFFD93030)
    val DarkRed = Color(0xFF830404)
}
