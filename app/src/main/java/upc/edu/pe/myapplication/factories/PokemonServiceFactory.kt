package upc.edu.pe.myapplication.factories

import upc.edu.pe.myapplication.model.remote.PokemonService

class PokemonServiceFactory {

    fun getpokemonService(): PokemonService {
        val retrofit = RetrofitFactory.getRetrofit()
        return retrofit.create(PokemonService::class.java)
    }

}