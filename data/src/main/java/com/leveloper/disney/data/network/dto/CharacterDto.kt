package com.leveloper.disney.data.network.dto

import com.google.gson.annotations.SerializedName

data class CharacterDto(
    @SerializedName("_id")
    val id: Int,

    @SerializedName("name")
    val name: String,

    @SerializedName("imageUrl")
    val image: String,

    @SerializedName("sourceUrl")
    val sourceUrl: String,

    @SerializedName("films")
    val films: List<String>,

    @SerializedName("shortFilms")
    val shortFilms: List<String>,

    @SerializedName("tvShows")
    val tvShows: List<String>,

    @SerializedName("videoGames")
    val videoGames: List<String>,

    @SerializedName("parkAttractions")
    val parkAttractions: List<String>,

    @SerializedName("allies")
    val allies: List<String>,

    @SerializedName("enemies")
    val enemies: List<String>
)