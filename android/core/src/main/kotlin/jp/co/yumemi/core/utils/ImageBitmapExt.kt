package jp.co.yumemi.core.utils

import android.graphics.Bitmap
import androidx.annotation.DrawableRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.ImageShader
import androidx.compose.ui.graphics.ShaderBrush
import androidx.compose.ui.graphics.TileMode
import androidx.compose.ui.graphics.asImageBitmap
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.toBitmap

@Composable
fun createImageBitmap(@DrawableRes resId: Int): ImageBitmap =
    ContextCompat.getDrawable(LocalContext.current, resId).let { drawable ->
        drawable!!.toBitmap(drawable.intrinsicWidth, drawable.intrinsicHeight, Bitmap.Config.ARGB_8888).asImageBitmap()
    }

@Composable
fun createShaderBrush(@DrawableRes resId: Int): Brush = ShaderBrush(
    ImageShader(
        image = createImageBitmap(resId),
        tileModeX = TileMode.Repeated,
        tileModeY = TileMode.Repeated,
    ),
)

@Composable
fun parseProductImageUrl(url: String?): String = if (url.isNullOrBlank()) {
    // URLが未設定の時はNoImage画像のURLを返す
    val context = LocalContext.current
    "android.resource://${context.packageName}/drawable/img_no_image_item_detail"
} else url
