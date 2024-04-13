package upc.edu.pe.myapplication.factories

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import upc.edu.pe.myapplication.network.ApiClient

class RetrofitFactory {
    companion object {
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ApiClient.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        }
    }
}