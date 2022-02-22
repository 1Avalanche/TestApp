package com.example.testapp.domain.common

interface EventHandler<T> {
    fun obtainEvent(event: T)
}