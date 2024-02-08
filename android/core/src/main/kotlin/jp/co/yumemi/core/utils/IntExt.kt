package jp.co.yumemi.core.utils

/**
 * 整数値をカンマ区切りの文字列に変換
 */
fun Int.toStringWithComma() = "%,d".format(this)

/**
 * 整数値を秒数として時間表記の文字列に変換
 */
fun Int.toTimeString() = "%d:%02d".format(this / 60, this % 60)
