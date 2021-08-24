package com.leveloper.disney.remote.service

import com.leveloper.disney.remote.dto.CharacterDto
import com.leveloper.disney.remote.dto.CharactersResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DisneyService {

    @GET("characters")
    suspend fun getCharacters(@Query("page") page: Int): CharactersResponse

    @GET("characters/{character_id}")
    suspend fun getCharacter(@Path("character_id") id: Int): CharacterDto
}