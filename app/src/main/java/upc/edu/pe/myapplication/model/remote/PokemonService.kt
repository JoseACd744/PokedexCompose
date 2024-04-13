package upc.edu.pe.myapplication.model.remote

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import upc.edu.pe.myapplication.model.data.Pokemon
import upc.edu.pe.myapplication.model.data.PokemonWrapper

interface PokemonService {

    @GET("pokemon/")
    fun getPokemonList(): Call<PokemonWrapper>

    @GET("pokemon/{id}")
    fun getPokemon(@Path("id")name: Int): Call<Pokemon>
}