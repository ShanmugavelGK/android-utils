package com.mycube.android_utils.motionToaster


import android.app.Activity
import android.content.Context
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.res.ResourcesCompat
import com.google.android.material.button.MaterialButton
import com.google.android.material.snackbar.Snackbar
import com.mycube.android_utils.R
import com.mycube.android_utils.motionToaster.MotionToast.Companion.createColorToast

object Toaster {
    fun showSnackBar(context: Context, parentLayout: View?, msg: String?) {
        showSnackBar(context, parentLayout, null, msg)
    }

    fun showSnackBar(context: Context, parentLayout: View?, anchorView: View?, msg: String?) {
        val snackbar = Snackbar.make(parentLayout!!, msg!!, Snackbar.LENGTH_SHORT)
        if (anchorView != null) snackbar.setAnchorView(anchorView)
        snackbar.setAction(context.getString(R.string.ok)) { view: View? -> }
        val actionView =
            snackbar.view.findViewById<MaterialButton>(com.google.android.material.R.id.snackbar_action)
        actionView?.setTextColor(context.getColor(androidx.appcompat.R.color.primary_dark_material_dark))
        if (!(context as AppCompatActivity).isFinishing) snackbar.show()
    }

    fun showErrorToast(context: Context?, msg: String?) {
        showErrorToast(context as AppCompatActivity?, msg)
    }

    @JvmStatic
    fun showErrorToast(activity: Activity?, msg: String?) {
        if (activity != null && !activity.isFinishing) {
            createColorToast(
                activity, activity.getString(R.string.text_error),
                msg!!,
                MotionToastStyle.ERROR,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(
                    activity,
                    R.font.poppins_regular_400
                )
            )
        }
    }

    @JvmStatic
    fun showSuccessToast(activity: Activity?, msg: String?) {
        if (activity != null && !activity.isFinishing) {

            createColorToast(
                activity, activity.getString(R.string.text_success),
                msg!!,
                MotionToastStyle.SUCCESS,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(
                    activity,
                    R.font.poppins_regular_400
                )
            )
        }
    }

    @JvmStatic
    fun showInfoToast(activity: Activity?, msg: String?) {
        if (activity != null && !activity.isFinishing) {
            createColorToast(
                activity, activity.getString(R.string.text_info),
                msg!!,
                MotionToastStyle.INFO,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(
                    activity,
                    R.font.poppins_regular_400
                )
            )
        }
    }

    fun showInfoToast(context: Context?, msg: String?) {
        showInfoToast(context as AppCompatActivity?, msg)
    }

    @JvmStatic
    fun showWarningToast(activity: Activity?, msg: String?) {
        if (activity != null && !activity.isFinishing) {
            createColorToast(
                activity, activity.getString(R.string.text_warning),
                msg!!,
                MotionToastStyle.WARNING,
                MotionToast.GRAVITY_BOTTOM,
                MotionToast.LONG_DURATION,
                ResourcesCompat.getFont(
                    activity,
                    R.font.poppins_regular_400
                )
            )
        }
    }
}
