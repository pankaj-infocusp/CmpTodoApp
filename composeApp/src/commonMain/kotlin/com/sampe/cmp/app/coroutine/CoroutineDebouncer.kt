package com.sampe.cmp.app.coroutine

import kotlinx.coroutines.CoroutineScope

/**
 * Debounce execution of a suspend function based on the given delay.
 */
interface CoroutineDebouncer {

    operator fun invoke(
        delay: Long = 300,
        coroutineScope: CoroutineScope,
        function: suspend () -> Unit,
    )
}
