package jp.co.yumemi.utils

// ref: https://github.com/arkivanov/Essenty
expect interface Parcelable

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.BINARY)
expect annotation class Parcelize()

@Target(AnnotationTarget.PROPERTY)
@Retention(AnnotationRetention.SOURCE)
expect annotation class IgnoreOnParcel()
