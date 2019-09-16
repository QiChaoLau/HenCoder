package com.ddxz.baseapp.repository.base

/**
 * author:LauQiChao
 * date:On 2019/9/15.
 */
sealed class Result<out T: Any> {
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}