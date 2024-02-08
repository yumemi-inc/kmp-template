package jp.co.yumemi.core.utils

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.keyframes
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.navigationBarsPadding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Rect
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp

fun Modifier.applyIf(
    condition: () -> Boolean,
    falseModifier: Modifier.() -> Modifier = { this },
    trueModifier: Modifier.() -> Modifier,
): Modifier = if (condition()) {
    trueModifier()
} else {
    falseModifier()
}

fun <T> Modifier.applyIfNotNull(
    condition: T?,
    modifier: Modifier.(T) -> Modifier,
): Modifier = if (condition != null) {
    modifier(condition)
} else {
    this
}

fun Modifier.clickableNoRipple(
    enabled: Boolean = true,
    onClickLabel: String? = null,
    role: Role? = null,
    onClick: () -> Unit,
): Modifier = composed {
    clickable(
        enabled = enabled,
        onClickLabel = onClickLabel,
        role = role,
        onClick = onClick,
        interactionSource = remember { MutableInteractionSource() },
        indication = null,
    )
}

@OptIn(ExperimentalComposeUiApi::class)
fun Modifier.screenPadding(
    dispatch: () -> Unit = {},
): Modifier = this
    .navigationBarsPadding()
    .statusBarsPadding()
    .imePadding()
    .composed {
        val keyboardController = LocalSoftwareKeyboardController.current
        val focusManager = LocalFocusManager.current
        clickable(
            interactionSource = remember { MutableInteractionSource() },
            indication = null,
        ) {
            dispatch()
            keyboardController?.hide()
            focusManager.clearFocus()
        }
    }

// TODO 以下、数字入力時のキャレット表示を行うために移植したが、使えない可能性が高いので確定したら削除します。
@Suppress("ModifierInspectorInfo")
fun Modifier.cursor(
    value: TextFieldValue,
    cursorBrush: Brush = SolidColor(Color.Unspecified),
) = composed {
    val cursorAlpha = remember { Animatable(1f) }
    LaunchedEffect(value.annotatedString, value.selection) {
        // ensure that the value is always 1f _this_ frame by calling snapTo
        cursorAlpha.snapTo(1f)
        // then start the cursor blinking on animation clock (500ms on to start)
        cursorAlpha.animateTo(0f, cursorAnimationSpec)
    }
    drawWithContent {
        this.drawContent()
        val cursorAlphaValue = cursorAlpha.value.coerceIn(0f, 1f)
        if (cursorAlphaValue != 0f) {
            val cursorRect = Rect(0f, 0f, 0f, 0f)
            val cursorWidth = DefaultCursorThickness.toPx()
            val cursorX = (cursorRect.left + cursorWidth / 2)
                .coerceAtMost(size.width - cursorWidth / 2)

            drawLine(
                cursorBrush,
                Offset(cursorX, cursorRect.top),
                Offset(cursorX, cursorRect.bottom),
                alpha = cursorAlphaValue,
                strokeWidth = cursorWidth,
            )
        }
    }
}

private val cursorAnimationSpec: AnimationSpec<Float> = infiniteRepeatable(
    animation = keyframes {
        durationMillis = 1000
        1f at 0
        1f at 499
        0f at 500
        0f at 999
    },
)

private val DefaultCursorThickness = 2.dp
// TODO 数字入力の削除ここまで
