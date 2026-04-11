@file:Suppress("UnusedImport") // Bug with kotlinx.coroutines.IO import

package com.sampe.cmp.app.coroutine

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO

@Suppress("InjectDispatcher")
internal class CoroutineDispatcherProviderImpl : CoroutineDispatcherProvider {

    override val io: CoroutineDispatcher = Dispatchers.IO
    override val main: CoroutineDispatcher = Dispatchers.Main
    override val default: CoroutineDispatcher = Dispatchers.Default
}
