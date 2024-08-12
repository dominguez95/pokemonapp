package com.example.pokemonapp.model

data class PokemonModels (
    val id: Long,
    val name: String,
    val avatar: String,
    val sprites: Sprites,
    val types: List<Type>
)
