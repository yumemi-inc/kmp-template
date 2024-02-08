package jp.co.yumemi.features.sample

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import jp.co.yumemi.core.R
import jp.co.yumemi.core.components.Button
import jp.co.yumemi.core.components.CommonTopAppBar
import jp.co.yumemi.core.components.LoadingIndicator
import jp.co.yumemi.core.foundation.Contract
import jp.co.yumemi.core.foundation.message
import jp.co.yumemi.core.primitives.SampleTheme
import jp.co.yumemi.core.utils.handleEvents
import jp.co.yumemi.core.utils.render
import jp.co.yumemi.core.utils.screenPadding
import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.SampleEntity
import jp.co.yumemi.sample.SampleEvent
import jp.co.yumemi.sample.SampleIntent
import jp.co.yumemi.sample.SampleState


@Composable
fun SampleScreenRoot(
    contract: Contract<SampleIntent, SampleState, SampleEvent>,
    navigator: SampleNavigator,
) {
    val (state, dispatch) = contract

    LaunchedEffect(Unit) {
        dispatch(SampleIntent.OnStart)
    }

    contract.handleEvents { event ->
        when (event) {
            is SampleEvent.NavigateNext -> navigator.next()
        }
    }

    SampleScreen(state = state, dispatch = dispatch)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SampleScreen(
    state: SampleState,
    dispatch: (SampleIntent) -> Unit,
) {
    Scaffold(
        topBar = {
            CommonTopAppBar(title = stringResource(R.string.sample_title))
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
            state.render<SampleState.Loading> {
                LoadingIndicator()
            }

            state.render<SampleState.Error> {
                Text(text = error.message())
            }
            state.render<SampleState.Stable> {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                ) {
                    Text(
                        text = sample.value,
                        style = SampleTheme.typography.headline1
                    )
                    Button(text = stringResource(R.string.sample_next)) { dispatch(SampleIntent.ClickNext) }
                }
            }
        }
    }
}

@Preview
@Preview(widthDp = 320, heightDp = 480)
@Composable
private fun PreviewSampleScreen() {
    SampleTheme {
        SampleScreen(state = SampleState.Stable(sample = SampleEntity(id = "1", value = "Preview")), dispatch = {})
    }
}

@Preview
@Preview(widthDp = 320, heightDp = 480)
@Composable
private fun PreviewSampleScreenLoading() {
    SampleTheme {
        SampleScreen(state = SampleState.Loading, dispatch = {})
    }
}

@Preview
@Preview(widthDp = 320, heightDp = 480)
@Composable
private fun PreviewSampleScreenError() {
    SampleTheme {
        SampleScreen(state = SampleState.Error(error = DomainError.Server()), dispatch = {})
    }
}
