package com.fajarsn.pokemonapp.data.source.network

import com.fajarsn.pokemonapp.data.PokemonResponse
import com.fajarsn.pokemonapp.data.source.response.PokemonListResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("pokemon")
    fun getPokemonList(
        @Query("offset") offset: Int = 0,
        @Query("limit") limit: Int = 20
    ): Call<PokemonListResponse>

    @GET("pokemon/{name}")
    fun getPokemonDetail(@Path("name") name: String) : Call<PokemonResponse>
}