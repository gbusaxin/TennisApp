package com.example.tennisapp.presentation.fragments.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tennisapp.databinding.FragmentHomeBinding
import com.example.tennisapp.presentation.AppViewModel
import com.squareup.picasso.Picasso

class HomeFragment : Fragment() {

    private lateinit var binding:FragmentHomeBinding
    private lateinit var viewModel: AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        binding = FragmentHomeBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val teamImage = binding.imageViewTeamImage
        val teamName = binding.textViewTeamName
        val teamInfo = binding.textViewTeamInfo
        val teamPlace = binding.textViewTeamPlace
        val teamRules = binding.textViewTeamRules

        val selectedTeam = activity?.intent?.getStringExtra("selectedTeam")?:""
        viewModel.getTeamItem(selectedTeam).observe(viewLifecycleOwner,{
            Picasso.get().load(it.image).into(teamImage)
            teamName.text = it.name
            teamInfo.text = it.mainInfo[0].info
            teamPlace.text = it.mainInfo[0].place
            teamRules.text = it.mainInfo[0].rules
        })
    }
}