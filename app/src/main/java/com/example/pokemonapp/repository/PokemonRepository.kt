package com.example.pokemonapp.repository

import android.content.Context
import coil.ImageLoader
import com.example.pokemonapp.data.PokemonApi
import com.example.pokemonapp.model.PokemonModels
import javax.inject.Inject

class PokemonRepository @Inject constructor(private val pokemonApi: PokemonApi){
    suspend fun getPokemon(): List<PokemonModels> {
        val response = pokemonApi.getPokemonApi()
        if (response.isSuccessful){
            val pokemonBody = response.body()?.results ?: emptyList()

            return pokemonBody.mapNotNull { pokemon ->
                // extraigo el id de las url para poder llegar al detalle
                val pokemonId = extraById(pokemon.url)
                val details = pokemonApi.getPokemonApiDetail(pokemonId)
                if(details.isSuccessful){
                    val detail = details.body()
                    detail?.let {
                        PokemonModels(id = it.id,
                            name = it.name,
                            avatar = getAvatar(it.id.toInt()),
                            sprites = it.sprites,
                            types = it.types)
                    }
                } else {
                     null
                }
            }
        }else {
         null
        }
        return emptyList()
    }

    private fun extraById(url: String): Int {
        return url.trimEnd('/').split("/").last().toInt()
    }

    private fun getAvatar(id: Int): String {
        return "https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/other/official-artwork/$id.png"
    }

}