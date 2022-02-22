package com.example.testapp.domain.common

sealed class ResponseWrapper<out T> {
    data class Success<out T>(val value: T): ResponseWrapper<T>()
    object Error: ResponseWrapper<Nothing>()
}