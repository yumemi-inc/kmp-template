package jp.co.yumemi.application

import android.content.Context
import android.os.Build.MANUFACTURER
import android.os.Build.MODEL
import android.os.Build.VERSION
import jp.co.yumemi.application.OperatingSystem

actual class Platform(val context: Context) {
    actual val operatingSystem: OperatingSystem = OperatingSystem.Android
    actual val osVersion: String = VERSION.RELEASE
    actual val device: String = "$MANUFACTURER $MODEL"
}
