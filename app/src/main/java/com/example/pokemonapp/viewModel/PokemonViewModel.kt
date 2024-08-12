package com.example.pokemonapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pokemonapp.model.PokemonModels
import com.example.pokemonapp.repository.PokemonRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class PokemonViewModel @Inject constructor(private val repo: PokemonRepository):ViewModel() {
    private  val _pokemons = MutableStateFlow<List<PokemonModels>>(emptyList())
    val pokemons = _pokemons.asStateFlow()

    init {
        fetchPokemons()
    }

    private fun fetchPokemons(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
            val result = repo.getPokemon()
                _pokemons.value = result ?: emptyList()
        } }
    }
}