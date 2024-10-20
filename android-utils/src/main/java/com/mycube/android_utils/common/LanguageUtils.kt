package com.mycube.android_utils.common

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;

import java.util.Locale;

/**
 * Created by Shanm$.
 * Date: $
 * Time: $
 */
object LanguageUtils {

    fun setAppLanguage(context: Context, localeString: String?) {
        val locale: Locale = Locale.Builder()
            .setLanguageTag(localeString!!)
            .build()

        Locale.setDefault(locale)

        val resources: Resources = context.resources
        val config: Configuration = resources.configuration

        config.setLocale(locale)
        resources.updateConfiguration(config, resources.displayMetrics)
    }


    fun updateBaseContextLocale(context: Context, localeString: String?): Context {
        val locale: Locale = Locale(localeString!!)

        Locale.setDefault(locale)

        val configuration: Configuration = Configuration(context.resources.configuration)
        configuration.setLocale(locale)

        return context.createConfigurationContext(configuration)
    }
}