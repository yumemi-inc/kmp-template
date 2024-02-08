package jp.co.yumemi.app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp
import jp.co.yumemi.app.BuildConfig
import timber.log.Timber
import timber.log.Timber.Forest.plant

@HiltAndroidApp
class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if (BuildConfig.DEBUG) {
            plant(Timber.DebugTree())
        }
    }
}
