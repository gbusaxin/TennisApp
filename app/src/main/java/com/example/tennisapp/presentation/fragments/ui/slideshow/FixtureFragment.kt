package com.example.tennisapp.presentation.fragments.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tennisapp.databinding.FragmentFixtureBinding
import com.example.tennisapp.presentation.AppViewModel
import com.example.tennisapp.presentation.adapters.FixturesAdapter

class FixtureFragment : Fragment() {

    private lateinit var binding: FragmentFixtureBinding
    private lateinit var adapter: FixturesAdapter
    private lateinit var viewModel: AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = FixturesAdapter()
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        binding = FragmentFixtureBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvFixture = binding.rvFixture
        val selectedTeam = activity?.intent?.getStringExtra("selectedTeam")?:""
        viewModel.getTeamItem(selectedTeam).observe(viewLifecycleOwner,{
            val fixture = it.fixtures
            adapter.list = fixture
            rvFixture.adapter = adapter
        })
    }

}