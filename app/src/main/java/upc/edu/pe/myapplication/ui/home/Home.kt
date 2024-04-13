package upc.edu.pe.myapplication.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import upc.edu.pe.myapplication.factories.PokemonServiceFactory
import upc.edu.pe.myapplication.model.data.Pokemon
import upc.edu.pe.myapplication.repositories.PokemonRepository

@Composable
fun Home() {
    val pokemons = remember {
        mutableStateOf(emptyList<Pokemon>())
    }

    val pokemonService = PokemonServiceFactory().getpokemonService()
    val pokemonRepository = PokemonRepository(pokemonService)

    pokemonRepository.getPokemonList { pokemonList ->
        pokemons.value = pokemonList ?: emptyList()
    }

    Scaffold { paddingValues ->
        Column(modifier = Modifier.padding(paddingValues)) {
            PokemonList(pokemons.value)
        }
    }
}

@Composable
fun PokemonList(pokemons: List<Pokemon>) {
    LazyColumn {
        items(pokemons) { pokemon ->
            PokemonCard(pokemon)
        }
    }
}

@Composable
fun PokemonCard(pokemon: Pokemon) {
    Card(modifier = Modifier
        .fillMaxWidth()
        .padding(8.dp)) {
        Row {
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = pokemon.name)
                Text(text = pokemon.url)
            }
        }
    }
}