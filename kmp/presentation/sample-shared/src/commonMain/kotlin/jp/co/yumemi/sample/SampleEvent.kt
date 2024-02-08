package jp.co.yumemi.sample

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.Event

sealed class SampleEvent : Event, Parcelable {
    @Parcelize
    data object NavigateNext : SampleEvent()
}
