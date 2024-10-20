package com.mycube.android_utils.common

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by Shanmugavel$.
 */

object AppPref {

    private const val MODE = Context.MODE_PRIVATE
    private lateinit var preferences: SharedPreferences

    // list of app specific preferences
    private val IS_LOGGED_IN = Pair("is_login_done", false)
    private val PROFILE_NAME = Pair("profile_name", "")
    private val USER_ID = Pair("user_id", "")
    private val ACCESS_TOKEN = Pair("access_token", "")
    private val IS_THEME_CHANGED = Pair("theme_changed", false)
    private val LANGUAGE_CODE = Pair("language_code", "en")


    fun init(context: Context, prefName: String) {
        preferences = context.getSharedPreferences(prefName, MODE)
    }


    /**
     * SharedPreferences extension function, so we won't need to call edit() and apply()
     * ourselves on every SharedPreferences operation.
     */
    private inline fun SharedPreferences.edit(operation: (SharedPreferences.Editor) -> Unit) {
        val editor = edit()
        operation(editor)
        editor.apply()
    }


    var profileName: String
        get() = preferences.getString(PROFILE_NAME.first, PROFILE_NAME.second)!!
        set(value) = preferences.edit {
            it.putString(PROFILE_NAME.first, value)
        }
    var userId: String
        get() = preferences.getString(USER_ID.first, USER_ID.second)!!
        set(value) = preferences.edit {
            it.putString(USER_ID.first, value)
        }
    var accessToken: String
        get() = preferences.getString(ACCESS_TOKEN.first, ACCESS_TOKEN.second)!!
        set(value) = preferences.edit {
            it.putString(ACCESS_TOKEN.first, value)
        }

    var isLoggedIn: Boolean
        get() = preferences.getBoolean(IS_LOGGED_IN.first, IS_LOGGED_IN.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_LOGGED_IN.first, value)
        }

    var isThemeChanged: Boolean
        get() = preferences.getBoolean(IS_THEME_CHANGED.first, IS_THEME_CHANGED.second)
        set(value) = preferences.edit {
            it.putBoolean(IS_THEME_CHANGED.first, value)
        }


    var languageCode: String
        get() = preferences.getString(LANGUAGE_CODE.first, LANGUAGE_CODE.second)!!
        set(value) = preferences.edit {
            it.putString(LANGUAGE_CODE.first, value)
        }


    fun setPrefBool(key: String, value: Boolean) {
        preferences.edit().putBoolean(key, value).apply()
    }

    fun getPrefBool(key: String, defaultValue: Boolean = false): Boolean {
        return preferences.getBoolean(key, defaultValue)
    }

    fun setPrefString(key: String, value: String) {
        preferences.edit().putString(key, value).apply()
    }

    fun getPrefString(key: String, defaultValue: String = ""): String? {
        return preferences.getString(key, defaultValue)
    }


    fun setPrefInt(key: String, value: Int) {
        preferences.edit().putInt(key, value).apply()
    }

    fun getPrefInt(key: String, defaultValue: Int = -1): Int {
        return preferences.getInt(key, defaultValue)
    }

    fun removePref() {
        preferences.edit().clear().apply()
    }
}