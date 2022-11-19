package com.soyaeeb.domain.base

import com.soyaeeb.domain.ApiResult
import kotlinx.coroutines.flow.Flow


interface BaseUseCase

interface ApiUseCase<Params, Type> : BaseUseCase {
    suspend operator fun invoke(params: Params): Flow<ApiResult<Type>>
}

interface ApiUseCaseNonParams<Type> : BaseUseCase {
    suspend operator fun invoke(): Flow<ApiResult<Type>>
}

interface RoomUseCaseNonParams<Type> : BaseUseCase {
    suspend fun execute(): Flow<Type>
}
interface RoomUseCaseParamsNoReturn<Params> : BaseUseCase {
    suspend fun execute(params: Params)
}

interface RoomUseCaseParams<Params,Type> : BaseUseCase {
    suspend fun execute(params: Params): Flow<Type>
}

interface RoomUseCaseNonParamsNoReturn : BaseUseCase {
    suspend fun execute()
}

interface RoomUseCaseParamsWithOutFlow<Params, Type> : BaseUseCase {
    suspend fun execute(param: Params) : Type
}

interface RoomUseCaseNonParamsWithOutFlow<Type> : BaseUseCase {
    suspend fun execute() : Type
}
