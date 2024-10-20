package com.mycube.androidutils

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mycube.android_utils.AndroidUtils
import com.mycube.android_utils.AndroidUtilsConfig
import com.mycube.android_utils.common.AppPref
import com.mycube.android_utils.motionToaster.Toaster
import com.mycube.androidutils.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val _binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Configure your SDK from the usage class
        val libraryConfig = AndroidUtilsConfig.Builder()
            .setSharePrefName("your-api-key-here")
            .setLogEnabled(true)
            .build()

        // Initialize your library with the config
        AndroidUtils
            .init(this, libraryConfig)
            .apply()


        _binding.tapHere.setOnClickListener {
            AppPref.profileName = "Lord Shivam"
            Toaster.showSuccessToast(this, "Login session expired.")
        }

    }
}