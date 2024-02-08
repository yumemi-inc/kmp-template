package jp.co.yumemi.data.models

import kotlinx.serialization.Serializable

@Serializable
data class SampleModel(
    val id: String,
    val value: String,
)
