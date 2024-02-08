package jp.co.yumemi.sample

import tech.fika.macaron.core.contract.Intent

sealed class SampleIntent : Intent {
    data object OnStart : SampleIntent()
    data object ClickNext : SampleIntent()
}
