package com.fajarsn.pokemonapp.presentation

import android.util.Log
import android.view.View
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.fajarsn.pokemonapp.data.Pokemon
import com.fajarsn.pokemonapp.data.PokemonResponse
import com.fajarsn.pokemonapp.data.source.network.ApiConfig
import com.fajarsn.pokemonapp.data.source.response.PokemonListResponse
import com.fajarsn.pokemonapp.utils.DataMapper
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel() {
    private val _pokemonList = MutableLiveData<List<Pokemon>>()
    val pokemonList: LiveData<List<Pokemon>> = _pokemonList

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading: LiveData<Boolean> = _isLoading

    private val _pokemonListResponse = MutableLiveData<PokemonListResponse>()
    val pokemonListResponse: LiveData<PokemonListResponse> = _pokemonListResponse

    private val _pokemonResponse = MutableLiveData<PokemonResponse>()
    val pokemonResponse : LiveData<PokemonResponse> = _pokemonResponse

    init {
        getPokemonList()
    }

    private fun getPokemonList() {
        _isLoading.value = true
        val client = ApiConfig.provideApiService().getPokemonList()

        client.enqueue(object : Callback<PokemonListResponse> {
            override fun onResponse(
                call: Call<PokemonListResponse>,
                response: Response<PokemonListResponse>
            ) {
                if (response.isSuccessful) {
                    _pokemonListResponse.value = response.body()


//                    responseBody?.results?.forEach { item ->
//                        val pokemon = getPokemonDetail(item.name)
//                        pokemon?.let { pokemonResponseList.add(it) }
//                    }
//
//                    val pokemonList = DataMapper.mapEntitiesToDomain(pokemonResponseList)
//                    _pokemonList.value = pokemonList
//                    _isLoading.value = false
                } else {
                    Log.e("TAG", "response failure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PokemonListResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("TAG", "failure: ${t.message}")
            }
        })
    }

    fun getPokemonDetail(name: String) {
        _isLoading.value = true
        val client = ApiConfig.provideApiService().getPokemonDetail(name)

        client.enqueue(object: Callback<PokemonResponse> {
            override fun onResponse(
                call: Call<PokemonResponse>,
                response: Response<PokemonResponse>
            ) {
                if (response.isSuccessful) {
                    _pokemonResponse.value = response.body()
                    _isLoading.value = false
                } else {
                    _isLoading.value = false
                    Log.e("TAG", "response failure: ${response.message()}")
                }
            }

            override fun onFailure(call: Call<PokemonResponse>, t: Throwable) {
                _isLoading.value = false
                Log.e("TAG", "failure: ${t.message}")
            }
        })
    }
}