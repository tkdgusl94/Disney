package com.leveloper.disney.remote.mapper

import com.leveloper.disney.data.model.CharacterData
import com.leveloper.disney.data.model.CharacterSnippetData
import com.leveloper.disney.remote.dto.CharacterDto
import com.leveloper.disney.remote.dto.CharacterSimpleDto

fun CharacterDto.toData(): CharacterData {
    return CharacterData(id, name, image, sourceUrl, films, shortFilms, tvShows, videoGames, parkAttractions, allies, enemies)
}

fun CharacterData.toDto(): CharacterDto {
    return CharacterDto(id, name, image, sourceUrl, films, shortFilms, tvShows, videoGames, parkAttractions, allies, enemies)
}

fun CharacterSimpleDto.toData(): CharacterSnippetData {
    return CharacterSnippetData(id, name ?: "", image ?: "")
}

fun CharacterSnippetData.toDto(): CharacterSimpleDto {
    return CharacterSimpleDto(id, name, image)
}