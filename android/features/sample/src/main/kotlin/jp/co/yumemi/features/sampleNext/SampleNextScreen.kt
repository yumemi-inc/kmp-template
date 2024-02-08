package jp.co.yumemi.features.sampleNext

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.core.R
import jp.co.yumemi.core.components.CommonTopAppBar
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.utils.screenPadding


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleNextScreenRoot() {
    Scaffold(
        topBar = {
            CommonTopAppBar(
                title = stringResource(R.string.sample_title),
            )
        },
        modifier = Modifier.screenPadding(),
    ) { contentPadding ->
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .fillMaxSize()
                .background(color = SampleTheme.colors.background)
                .padding(paddingValues = contentPadding),
        ) {
            Text(
                text = stringResource(R.string.sample_next_screen),
                style = SampleTheme.typography.headline1
            )
        }
    }
}

@Preview
@Preview(widthDp = 320, heightDp = 480)
@Composable
private fun PreviewSampleScreen() {
    SampleTheme {
        SampleNextScreenRoot()
    }
}
