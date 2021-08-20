package com.leveloper.disney.data.network.dto

import com.google.gson.annotations.SerializedName
import com.leveloper.disney.domain.model.CharacterSnippet

data class CharacterSimpleDto(
    @SerializedName("_id")
    val id: Int,

    @SerializedName("name")
    val name: String? = "",

    @SerializedName("imageUrl")
    val image: String? = ""
) {
    fun toModel(): CharacterSnippet {
        return CharacterSnippet(id, name ?: "", image ?: "")
    }
}