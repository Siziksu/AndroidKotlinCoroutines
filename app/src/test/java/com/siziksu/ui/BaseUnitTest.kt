package com.siziksu.ui

import android.util.Log
import io.mockk.every
import io.mockk.mockkStatic
import org.junit.Before

open class BaseUnitTest {

    @Before
    fun baseSetup() {
        mockkStatic(Log::class)
        every { Log.v(any(), any()) } returns 0
        every { Log.d(any(), any()) } returns 0
        every { Log.i(any(), any()) } returns 0
        every { Log.e(any(), any()) } returns 0
    }
}
