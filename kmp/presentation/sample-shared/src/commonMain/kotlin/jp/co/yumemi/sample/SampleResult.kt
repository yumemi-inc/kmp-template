package jp.co.yumemi.sample

import jp.co.yumemi.domain.core.DomainError
import jp.co.yumemi.domain.entities.SampleEntity
import tech.fika.macaron.core.contract.Result

sealed class SampleResult : Result {
    data object Loading : SampleResult()
    data class GetSampleSuccess(val sample: SampleEntity) : SampleResult()
    data class GetSampleError(val error: DomainError) : SampleResult()
}
