package jp.co.yumemi.core.foundation

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import jp.co.yumemi.core.R
import jp.co.yumemi.domain.core.DomainError

@Composable
fun DomainError.message(): String = when (this) {
    is DomainError.Maintenance -> stringResource(id = R.string.sample_error_maintenance_description)
    is DomainError.LoginRequired -> stringResource(id = R.string.sample_error_login_description)
    is DomainError.Server -> this.throwable?.message ?: stringResource(id = R.string.sample_error_network_description)
    else -> stringResource(id = R.string.sample_error_network_description)
}
