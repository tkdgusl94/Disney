package com.leveloper.disney.data.mapper

import com.leveloper.disney.data.model.CharacterData
import com.leveloper.disney.data.model.CharacterSnippetData
import com.leveloper.disney.domain.model.Character
import com.leveloper.disney.domain.model.CharacterSnippet

fun CharacterData.toModel(): Character {
    return Character(id, name, image, sourceUrl, films, shortFilms, tvShows, videoGames, parkAttractions, allies, enemies)
}

fun CharacterSnippetData.toModel(): CharacterSnippet {
    return CharacterSnippet(id, name, image)
}