package com.base.utils

import android.util.Log
import com.mvvm.base.common.BuildConfig

object LogUtil {
    private var isDebug = BuildConfig.DEBUG
    private const val TAG = "Brett"

    fun e(content: Int) {
        if (isDebug) {
            Log.e(TAG, content.toString() + "")
        }
    }

    fun e(content: String?) {
        if (isDebug && !content.isNullOrEmpty()) {
            Log.e(TAG, content)
        }
    }

    fun e(tag: String, content: Int) {
        Log.e(tag, content.toString() + "")
    }

    fun e(tag: String, content: String?) {
        if (isDebug && !content.isNullOrEmpty()) {
            Log.e(tag, content)
        }
    }

    fun w(msg: String?) {
        if (isDebug && !msg.isNullOrEmpty()) {
            Log.w(TAG, msg)
        }
    }

    fun w(tag: String, msg: String?) {
        if (isDebug && !msg.isNullOrEmpty()) {
            Log.w(tag, msg)
        }
    }

    fun d(content: String?) {
        if (isDebug && !content.isNullOrEmpty()) {
            Log.d(TAG, content)
        }
    }

    fun d(tag: String, content: String?) {
        if (isDebug && !content.isNullOrEmpty()) {
            Log.d(tag, content)
        }
    }

    fun i(content: String?) {
        if (isDebug && !content.isNullOrEmpty()) {
            Log.i(TAG, content)
        }
    }

    fun i(tag: String, content: String?) {
        if (isDebug && !content.isNullOrEmpty()) {
            Log.i(tag, content)
        }
    }
}