package jp.co.yumemi.remote.models

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class SampleApiModel(
    @SerialName(value = "id")
    val id: String,
    @SerialName(value = "value")
    val value: String,
)
