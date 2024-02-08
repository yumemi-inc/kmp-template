package jp.co.yumemi.core.components

import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults.topAppBarColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.core.primitives.SampleTheme

@ExperimentalMaterial3Api
@Composable
fun CommonTopAppBar(
    title: String,
    modifier: Modifier = Modifier,
    navigationIcon: @Composable () -> Unit = {},
    actions: @Composable RowScope.() -> Unit = {},
) {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = title,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                style = SampleTheme.typography.headline1,
            )
        },
        modifier = modifier,
        colors = topAppBarColors(
            containerColor = SampleTheme.colors.primary,
            navigationIconContentColor = SampleTheme.colors.onPrimary,
            titleContentColor = SampleTheme.colors.onPrimary,
            actionIconContentColor = SampleTheme.colors.onPrimary,
        ),
        navigationIcon = navigationIcon,
        actions = actions,
    )
}

@ExperimentalMaterial3Api
@Preview
@Composable
internal fun PreviewCommonTopAppBar() {
    SampleTheme {
        CommonTopAppBar(
            title = "Title",
        )
    }
}

@ExperimentalMaterial3Api
@Preview
@Composable
internal fun PreviewCommonTopAppBarWithButtons() {
    SampleTheme {
        CommonTopAppBar(
            title = "Title",
            navigationIcon = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
                }
            },
            actions = {
                IconButton(onClick = {}) {
                    Icon(imageVector = Icons.Default.Add, contentDescription = null)
                }
            },
        )
    }
}
