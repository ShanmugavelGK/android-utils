package com.mycube.android_utils.common

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.mycube.android_utils.R
import java.io.Serializable

class ActivitySwitchManager(var activity: Activity, destinationActivity: Class<*>) {
    private var newActivity: Class<*>
    private var mMenuIntent: Intent
    private val extras: MutableMap<String, Any>

    init {
        mMenuIntent = Intent(activity, destinationActivity)
        newActivity = destinationActivity
        extras = HashMap()
    }

    fun addExtra(key: String, value: Any): ActivitySwitchManager {
        extras[key] = value
        return this
    }

    fun addFlags(flag: Int): ActivitySwitchManager {
        mMenuIntent.addFlags(flag)
        return this
    }

    @JvmOverloads
    fun switchActivity(killCurrentActivity: Boolean = false, disableSlideAnim: Boolean = false) {
        if (extras.isNotEmpty()) {
            val bundle = Bundle()
            for ((key, value) in extras) {
                when (value) {
                    is String -> {
                        bundle.putString(key, value)
                    }

                    is Int -> {
                        bundle.putInt(key, value)
                    }

                    is Boolean -> {
                        bundle.putBoolean(key, value)
                    }

                    is Float -> {
                        bundle.putFloat(key, value)
                    }

                    is Double -> {
                        bundle.putDouble(key, value)
                    }

                    else -> {
                        bundle.putSerializable(key, value as Serializable)
                    }
                }
            }
            mMenuIntent.putExtras(bundle)
        }

        //add flags to clear all activities
        if (killCurrentActivity) mMenuIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        activity.startActivity(mMenuIntent)

        //finish current activity
        if (killCurrentActivity) activity.finish()


        //add animation if required
        if (!disableSlideAnim) activity.overridePendingTransition(
            R.anim.slide_in_right,
            R.anim.slide_out_left
        )
    }

    fun switchToBackActivity() {
        switchActivity(killCurrentActivity = false, disableSlideAnim = true)
        activity.overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right)
    }


}
