package jp.co.yumemi.domain.usecases

import jp.co.yumemi.domain.core.UseCase
import jp.co.yumemi.domain.entities.SampleEntity
import jp.co.yumemi.domain.repositories.SampleRepository

interface SampleUseCase : UseCase<SampleUseCase.Args, SampleEntity> {
    data class Args(val id: String)
}

class SampleExecutor(
    private val sampleRepository: SampleRepository,
) : SampleUseCase {
    override suspend fun execute(arguments: SampleUseCase.Args): SampleEntity = sampleRepository.getSample(id = arguments.id)
}
