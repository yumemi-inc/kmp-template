package jp.co.yumemi.sample

import jp.co.yumemi.domain.core.ErrorHandler
import jp.co.yumemi.domain.core.runHandling
import jp.co.yumemi.domain.usecases.SampleUseCase
import tech.fika.macaron.statemachine.components.StateMachine
import tech.fika.macaron.statemachine.components.event
import tech.fika.macaron.statemachine.components.result

class SampleStateMachine(
    private val sampleUseCase: SampleUseCase,
    private val errorHandler: ErrorHandler,
) : StateMachine<
        SampleIntent,
        SampleAction,
        SampleResult,
        SampleState,
        SampleEvent,
        >(
    builder = {
        state<SampleState.Initial> {
            interpret<SampleIntent.OnStart> { SampleAction.GetSample }

            process<SampleAction.GetSample> {
                result(SampleResult.Loading)
                runHandling(errorHandler) {
                    sampleUseCase.execute(arguments = SampleUseCase.Args(id = "1"))
                }.onSuccess {
                    result(SampleResult.GetSampleSuccess(sample = it))
                }.onFailure {
                    result(SampleResult.GetSampleError(error = it))
                }
            }

            reduce<SampleResult.Loading> { SampleState.Loading }
        }

        state<SampleState.Loading> {
            reduce<SampleResult.GetSampleSuccess> { SampleState.Stable(sample = result.sample) }
            reduce<SampleResult.GetSampleError> { SampleState.Error(error = result.error) }
        }

        state<SampleState.Stable> {
            interpret<SampleIntent.ClickNext> { SampleAction.NavigateNext }

            process<SampleAction.NavigateNext> { event(SampleEvent.NavigateNext) }
        }
    },
)
