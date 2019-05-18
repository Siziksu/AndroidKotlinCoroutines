package com.siziksu.data.common.utils

import android.util.Log

class Logs {

    companion object {

        private const val TAG = "Coroutines [Data]"

        fun print(message: String) {
            Log.d(TAG, message)
        }

        fun error(message: String) {
            Log.e(TAG, message)
        }
    }
}