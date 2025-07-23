package com.example.bookshelf.data.model

import com.google.gson.annotations.SerializedName

data class VolumeItem(
    val id: String,
    @SerializedName("volumeInfo")
    val volumeInfo: VolumeInfo
)