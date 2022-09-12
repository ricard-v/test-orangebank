package com.mackosoft.testorangebank.usecases

interface UseCase<Type, Param> {
    suspend fun call(param: Param): Result<Type>
}