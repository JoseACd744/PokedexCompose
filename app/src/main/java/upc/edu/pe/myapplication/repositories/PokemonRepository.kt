package upc.edu.pe.myapplication.repositories

import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import upc.edu.pe.myapplication.model.data.Pokemon
import upc.edu.pe.myapplication.model.remote.PokemonService
import upc.edu.pe.myapplication.model.data.PokemonWrapper

class PokemonRepository(
    private val pokemonService: PokemonService
) {

    fun getPokemonList(
        callback: (List<Pokemon>?) -> Unit
    )
    {
        val callPokemon = pokemonService.getPokemonList()
        callPokemon.enqueue(object : Callback<PokemonWrapper> {
            override fun onResponse(call: Call<PokemonWrapper>, response: Response<PokemonWrapper>) {
                if (response.isSuccessful) {
                    val pokemonWrapper = response.body()
                    callback(pokemonWrapper?.pokemons)
                } else {
                    callback(null)
                }
            }

            override fun onFailure(call: Call<PokemonWrapper>, t: Throwable) {
                t.message?.let { Log.e("PokemonRepository", it) }
            }
        })
    }

}