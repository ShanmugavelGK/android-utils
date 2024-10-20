package com.mycube.android_utils.common

import android.util.Log

/**
 * Created by Shanmugavel$.
 * Date: $
 * Time: $
 */
object TRACE {

    @JvmStatic
    fun logCat(string: String) {
        Log.d("cubiz", string)
    }

    @JvmStatic
    fun logDebug(string: String) {
        logCat(string)
    }

    @JvmStatic
    fun logWarning(string: String) {
        Log.w("cubiz", string)
    }

    @JvmStatic
    fun logInfo(string: String) {
        Log.i("cubiz", string)
    }

    @JvmStatic
    fun logVerbose(string: String) {
        Log.v("cubiz", string)
    }

    @JvmStatic
    fun logError(string: String) {
        Log.e("cubiz", string)
    }
}