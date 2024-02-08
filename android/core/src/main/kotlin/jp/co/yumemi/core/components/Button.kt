package jp.co.yumemi.core.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.primitives.Shapes
import jp.co.yumemi.core.primitives.Spacing
import jp.co.yumemi.core.primitives.a70

@Composable
fun Button(
    text: String,
    modifier: Modifier = Modifier,
    size: ButtonSize = ButtonSize.L,
    enabled: Boolean = true,
    onClick: () -> Unit,
) {
    Button(
        enabled = enabled,
        shape = Shapes.medium,
        modifier = modifier.sizeIn(
            minWidth = when (size) {
                ButtonSize.L -> 120.dp
                ButtonSize.M -> 100.dp
                ButtonSize.S -> 80.dp
            }
        ),
        contentPadding = when (size) {
            ButtonSize.L -> PaddingValues(vertical = Spacing.S, horizontal = Spacing.S)
            ButtonSize.M -> PaddingValues(vertical = Spacing.XS, horizontal = Spacing.XS)
            ButtonSize.S -> PaddingValues(vertical = Spacing.XS, horizontal = Spacing.XS)
        },
        colors = ButtonDefaults.buttonColors(
            containerColor = SampleTheme.colors.primaryVariant,
            contentColor = SampleTheme.colors.onPrimary,
            disabledContainerColor = SampleTheme.colors.primaryVariant.a70,
            disabledContentColor = SampleTheme.colors.onPrimary,
        ),
        onClick = onClick,
    ) {
        Text(
            text = text,
            style = when (size) {
                ButtonSize.L -> SampleTheme.typography.button1
                ButtonSize.M -> SampleTheme.typography.button2
                ButtonSize.S -> SampleTheme.typography.button3
            },
        )
    }
}

enum class ButtonSize {
    L, M, S
}