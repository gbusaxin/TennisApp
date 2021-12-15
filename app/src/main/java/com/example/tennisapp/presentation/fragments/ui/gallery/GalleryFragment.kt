package com.example.tennisapp.presentation.fragments.ui.gallery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tennisapp.databinding.FragmentGalleryBinding
import com.example.tennisapp.presentation.AppViewModel
import com.example.tennisapp.presentation.adapters.PlayerAdapter

class GalleryFragment : Fragment() {

    private lateinit var binding: FragmentGalleryBinding
    private lateinit var viewModel:AppViewModel
    private lateinit var adapter:PlayerAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        adapter = PlayerAdapter()
       binding = FragmentGalleryBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvPlayers = binding.rvPlayers
        val selectedTeam = activity?.intent?.getStringExtra("selectedTeam")?:""
        viewModel.getTeamItem(selectedTeam).observe(viewLifecycleOwner,{
            val list = it.players
            adapter.list = list
            rvPlayers.adapter = adapter
        })
    }

}