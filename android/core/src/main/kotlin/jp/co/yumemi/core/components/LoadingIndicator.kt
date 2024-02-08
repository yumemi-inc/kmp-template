package jp.co.yumemi.core.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.material3.Button
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.primitives.Size

@Composable
fun LoadingIndicator(modifier: Modifier = Modifier) {
    Box(
        contentAlignment = Alignment.Center,
        modifier = modifier
            .fillMaxSize()
            .pointerInput(key1 = Unit) { /* 他の要素を操作できないよう入力イベントを奪う */ },
    ) {
        CircularProgressIndicator(
            color = SampleTheme.colors.onBackground,
            strokeWidth = 4.dp,
            modifier = Modifier.size(Size.XL),
        )
    }
}

@Preview
@Composable
internal fun PreviewLoadingIndicator() {
    SampleTheme {
        Box {
            Box(contentAlignment = Alignment.TopCenter, modifier = Modifier.fillMaxSize()) {
                Button(onClick = { }) {
                    Text(text = "背面のは押せない")
                }
            }

            LoadingIndicator()

            Box(contentAlignment = Alignment.BottomCenter, modifier = Modifier.fillMaxSize()) {
                Button(onClick = { }) {
                    Text(text = "前面のは押せる")
                }
            }
        }
    }
}