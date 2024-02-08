package jp.co.yumemi.core.primitives

import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

@Immutable
data class SampleTypography(
    val title: TextStyle,
    val headline1: TextStyle,
    val headline2: TextStyle,
    val subtitle: TextStyle,
    val body1: TextStyle,
    val body2: TextStyle,
    val body3: TextStyle,
    val body4: TextStyle,
    val button1: TextStyle,
    val button2: TextStyle,
    val button3: TextStyle,
)

val LocalCustomTypography = staticCompositionLocalOf {
    SampleTypography(
        title = TextStyle.Default,
        headline1 = TextStyle.Default,
        headline2 = TextStyle.Default,
        subtitle = TextStyle.Default,
        body1 = TextStyle.Default,
        body2 = TextStyle.Default,
        body3 = TextStyle.Default,
        body4 = TextStyle.Default,
        button1 = TextStyle.Default,
        button2 = TextStyle.Default,
        button3 = TextStyle.Default,
    )
}

val CustomTypography = SampleTypography(
    title = TextStyle(fontSize = 28.sp, fontWeight = FontWeight.Bold),
    headline1 = TextStyle(fontSize = 20.sp, fontWeight = FontWeight.Bold),
    headline2 = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
    subtitle = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold),
    body1 = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.Medium),
    body2 = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
    body3 = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
    body4 = TextStyle(fontSize = 12.sp, fontWeight = FontWeight.Normal),
    button1 = TextStyle(fontSize = 18.sp, fontWeight = FontWeight.Bold),
    button2 = TextStyle(fontSize = 16.sp, fontWeight = FontWeight.SemiBold),
    button3 = TextStyle(fontSize = 14.sp, fontWeight = FontWeight.Medium),
)
