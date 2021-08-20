package com.leveloper.disney.data.network.dto

import com.google.gson.annotations.SerializedName

data class CharactersResponse(
    @SerializedName("data")
    val characters: List<CharacterSnippet>,

    @SerializedName("count")
    val count: Int,

    @SerializedName("nextPage")
    val nextPage: String
) {

    data class CharacterSnippet(
        @SerializedName("_id")
        val id: Int,

        @SerializedName("name")
        val name: String,

        @SerializedName("imageUrl")
        val image: String
    )
}