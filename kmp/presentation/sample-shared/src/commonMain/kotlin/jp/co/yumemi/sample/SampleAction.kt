package jp.co.yumemi.sample

import tech.fika.macaron.core.contract.Action

sealed class SampleAction : Action {
    data object GetSample : SampleAction()
    data object NavigateNext : SampleAction()
}
