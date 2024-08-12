package com.example.pokemonapp.model

data class PokemonApiModel (
    val count: Long,
    val next: String,
    val previous: Any? = null,
    val results: List<Result>
)

data class Result (
    val name: String,
    val url: String
)
