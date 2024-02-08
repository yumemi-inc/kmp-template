package jp.co.yumemi.core.utils

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.sp

/**
 * 固定文字サイズ
 */
private val Float.nonScaledSp
    @Composable
    get() = (this / LocalDensity.current.fontScale).sp

/**
 * 固定文字サイズに変換
 */
@Composable
fun TextStyle.toNonScale(): TextStyle {
    return copy(fontSize = fontSize.value.nonScaledSp)
}

@Composable
fun Dp.toPx(): Float {
    val density = LocalDensity.current
    with(density) {
        return this@toPx.toPx()
    }
}
