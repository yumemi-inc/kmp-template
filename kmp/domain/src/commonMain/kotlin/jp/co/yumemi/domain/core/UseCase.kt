package jp.co.yumemi.domain.core

interface UseCase<in Arguments, out ReturnType> {
    suspend fun execute(arguments: Arguments): ReturnType
}

suspend fun <T> UseCase<Unit, T>.execute(): T = execute(Unit)
