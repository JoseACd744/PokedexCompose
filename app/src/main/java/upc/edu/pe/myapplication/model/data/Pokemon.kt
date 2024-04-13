package upc.edu.pe.myapplication.model.data

import com.google.gson.annotations.SerializedName


data class PokemonWrapper(
    @SerializedName("results")
    val pokemons: List<Pokemon>
)


data class Pokemon(
    @SerializedName("name")
    val name: String,
    @SerializedName("url")
    val url: String
)
