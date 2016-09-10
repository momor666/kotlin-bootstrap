package com.sbhachu.bootstrap.application

import android.app.Application
import android.content.pm.PackageInfo
import android.provider.Settings
import android.util.Log
import com.sbhachu.bootstrap.extensions.addLifecycleCallbacks

class KotlinApplication : Application() {

    private val TAG: String = this@KotlinApplication.javaClass.simpleName

    companion object {
        lateinit var app: KotlinApplication
            private set
    }

    override fun onCreate() {
        super.onCreate()

        addLifecycleCallbacks {
            onActivityCreated { activity, bundle -> Log.d(TAG, "onActivityCreated") }
            onActivityResumed { activity -> Log.d(TAG, "onActivityResumed") }
        }

        app = this
    }


    fun deviceId(): String = Settings.Secure.getString(this.contentResolver, Settings.Secure.ANDROID_ID)

    fun version(): String {
        try {
            val packageInfo: PackageInfo = packageManager.getPackageInfo(packageName, 0)
            return "${packageInfo.versionName} (${packageInfo.versionCode})"
        } catch (e: Exception) {
            return ""
        }
    }

    fun versionCode(): String {
        try {
            val packageInfo: PackageInfo = packageManager.getPackageInfo(packageName, 0)
            return "${packageInfo.versionCode}"
        } catch (e: Exception) {
            return ""
        }
    }


}
