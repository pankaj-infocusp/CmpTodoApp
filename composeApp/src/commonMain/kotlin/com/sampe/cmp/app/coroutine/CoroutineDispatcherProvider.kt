package com.sampe.cmp.app.coroutine

import kotlinx.coroutines.CoroutineDispatcher

/**
 * Interface to provide different [CoroutineDispatcher] implementations.
 */
interface CoroutineDispatcherProvider {

    val io: CoroutineDispatcher
    val main: CoroutineDispatcher
    val default: CoroutineDispatcher
}
