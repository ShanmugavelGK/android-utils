package com.mycube.android_utils

/**
 * Created by Shan$.
 * Date: $
 * Time: $
 */
class AndroidUtilsConfig private constructor(
    val sharedPrefName: String?,
    val isLogEnabled: Boolean = true,
) {
    init {
        require(!sharedPrefName.isNullOrEmpty()) { "Shared Pref Name must not be empty" }
    }

    // Builder pattern for easy configuration
    class Builder {
        private var sharedPrefName: String? = null
        private var isLogEnabled: Boolean = true

        fun setSharePrefName(name: String) = apply { this.sharedPrefName = name }
        fun setLogEnabled(isLogEnabled: Boolean) = apply { this.isLogEnabled = isLogEnabled }

        fun build(): AndroidUtilsConfig {
            return AndroidUtilsConfig(sharedPrefName, isLogEnabled)
        }
    }
}
