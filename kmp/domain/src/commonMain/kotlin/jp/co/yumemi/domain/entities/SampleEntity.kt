package jp.co.yumemi.domain.entities

import jp.co.yumemi.utils.Parcelable
import jp.co.yumemi.utils.Parcelize

@Parcelize
data class SampleEntity(
    val id: String,
    val value: String
) : Parcelable