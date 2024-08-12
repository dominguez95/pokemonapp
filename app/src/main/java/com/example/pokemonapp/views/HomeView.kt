package com.example.pokemonapp.views

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.pokemonapp.R
import com.example.pokemonapp.viewModel.PokemonViewModel


@Composable
fun HomeView(viewModel: PokemonViewModel) {
val pokemons by viewModel.pokemons.collectAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.pokeball_dark),
            contentDescription = "Background",
            contentScale = ContentScale.FillWidth,
        modifier = Modifier
            .fillMaxSize(0.5f)
            .align(Alignment.TopEnd)
            .offset(x=20.dp, y = (-190).dp)
            .alpha(0.5f)
            )
    }
    LazyColumn {
        items(pokemons){ item ->
            Text(text = item.name)
        }
    }
}