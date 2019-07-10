package com.siziksu.data.common.utils

import android.util.Log

class Logs {

    companion object {

        private const val TAG = "APP_LOG"

        fun print(message: String) = Log.d(TAG, message)

        fun error(message: String) = Log.e(TAG, message)

        fun error(e: Exception) = Log.e(TAG, e.message, e)
    }
}
