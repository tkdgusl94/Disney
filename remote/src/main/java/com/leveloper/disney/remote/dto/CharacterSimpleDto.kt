package com.leveloper.disney.remote.dto

import com.google.gson.annotations.SerializedName

data class CharacterSimpleDto(
    @SerializedName("_id")
    val id: Int,

    @SerializedName("name")
    val name: String? = "",

    @SerializedName("imageUrl")
    val image: String? = ""
)