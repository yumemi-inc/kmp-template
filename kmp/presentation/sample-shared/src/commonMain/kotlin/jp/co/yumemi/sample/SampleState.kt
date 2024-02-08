package jp.co.yumemi.sample

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.SampleEntity
import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize
import tech.fika.macaron.core.contract.State

sealed class SampleState : State, Parcelable {
    @Parcelize
    data object Initial : SampleState()

    @Parcelize
    data object Loading : SampleState()

    @Parcelize
    data class Stable(
        val sample: SampleEntity
    ) : SampleState()

    @Parcelize
    data class Error(
        val error: DomainError
    ) : SampleState()
}
