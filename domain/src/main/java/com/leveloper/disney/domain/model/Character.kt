package com.leveloper.disney.domain.model

data class Character(
    val id: Int,
    val name: String,
    val image: String,
    val sourceUrl: String,
    val films: List<String>,
    val shortFilms: List<String>,
    val tvShows: List<String>,
    val videoGames: List<String>,
    val parkAttractions: List<String>,
    val allies: List<String>,
    val enemies: List<String>
)