package com.mycube.android_utils

import android.content.Context
import com.mycube.android_utils.common.AppPref

/**
 * Created by Shan$.
 * Date: $
 * Time: $
 */

class AndroidUtils private constructor(
    private val context: Context,
    private val config: AndroidUtilsConfig
) {

    fun apply() {
        AppPref.init(context, config.sharedPrefName!!)
    }

    companion object {
        // Factory method to create an instance of the library with configuration
        fun init(context: Context, config: AndroidUtilsConfig): AndroidUtils {
            return AndroidUtils(context, config)
        }
    }
}