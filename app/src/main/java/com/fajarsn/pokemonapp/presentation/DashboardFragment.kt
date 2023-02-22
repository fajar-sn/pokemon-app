package com.fajarsn.pokemonapp.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.fajarsn.pokemonapp.data.Pokemon
import com.fajarsn.pokemonapp.data.PokemonResponse
import com.fajarsn.pokemonapp.databinding.FragmentDashboardBinding
import com.fajarsn.pokemonapp.utils.DataMapper

class DashboardFragment : Fragment() {
    private var _binding: FragmentDashboardBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView = binding.pokemonListRecyclerView
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 3)
        val mainViewModel = ViewModelProvider(requireActivity(), ViewModelProvider.NewInstanceFactory())[MainViewModel::class.java]
        val pokemonResponseList = mutableListOf<PokemonResponse>()

        mainViewModel.pokemonListResponse.observe(requireActivity()) { response ->
            response.results.forEach { item ->
                mainViewModel.getPokemonDetail(item.name)
            }

            val pokemonList = DataMapper.mapEntitiesToDomain(pokemonResponseList)
            recyclerView.adapter = PokemonListAdapter(pokemonList)
        }

        mainViewModel.pokemonResponse.observe(requireActivity()) { response ->
            pokemonResponseList.add(response)
        }

        mainViewModel.isLoading.observe(requireActivity()) {
            binding.progressBar.visibility = if (it) View.VISIBLE else View.GONE
        }


//        getPokemonList()
//        recyclerView.adapter = PokemonListAdapter(pokemonList)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}