package com.example.pokemonapp.data

import com.example.pokemonapp.model.PokemonApiDetailsModels
import com.example.pokemonapp.model.PokemonApiModel
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {
    @GET("pokemon?limit=15&offset=0")
    suspend fun getPokemonApi(): Response<PokemonApiModel>
    @GET("pokemon/{id}/")
    suspend fun getPokemonApiDetail(@Path("id") id: Int): Response<PokemonApiDetailsModels>
}