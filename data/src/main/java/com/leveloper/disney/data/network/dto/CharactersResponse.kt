package com.leveloper.disney.data.network.dto

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("data")
    val characters: List<CharacterSimpleDto>,

    @SerializedName("count")
    val count: Int,

    @SerializedName("nextPage")
    val nextPage: String
)