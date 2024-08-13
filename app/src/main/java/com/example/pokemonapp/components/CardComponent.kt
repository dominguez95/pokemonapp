package com.example.pokemonapp.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import coil.compose.AsyncImage
import com.example.pokemonapp.R
import com.example.pokemonapp.model.PokemonModels

@Composable
fun CardComponent(params: PokemonModels) {

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .wrapContentHeight(),
        elevation = CardDefaults.elevatedCardElevation(),
        shape = RoundedCornerShape(8.dp),
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            // Imagen de fondo
            Image(
                painter = painterResource(id = R.drawable.pokeball_light), // Reemplaza con tu recurso de imagen
                contentDescription = "Fondo",
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .size(100.dp), // Tamaño de la imagen
                contentScale = ContentScale.Crop
            )

            Row(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {

                Box(
                    modifier = Modifier
                        .weight(1f)
                        .fillMaxHeight()
                ) {}

                Spacer(modifier = Modifier.weight(1f))

                // Imagen que debe sobresalir
                AsyncImage(
                    model = params.avatar,
                    contentDescription = null,
                    modifier = Modifier
                        .size(100.dp)
                        .offset(x=25.dp,y = (-2).dp) // Ajusta la posición para que sobresalga
                        .zIndex(-3f) // Asegura que esté por encima de otros elementos
                )
            }
        }
    }



}