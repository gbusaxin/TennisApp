package com.example.tennisapp.presentation.fragments.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.tennisapp.databinding.FragmentResultBinding
import com.example.tennisapp.presentation.AppViewModel
import com.example.tennisapp.presentation.adapters.ResultAdapter

class ResultFragment : Fragment() {

    private lateinit var binding: FragmentResultBinding
    private lateinit var adapter: ResultAdapter
    private lateinit var viewModel: AppViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = ResultAdapter()
        viewModel = ViewModelProvider(this)[AppViewModel::class.java]
        binding = FragmentResultBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val rvResult = binding.rvResult
        val selectedTeam = activity?.intent?.getStringExtra("selectedTeam")?:""
        viewModel.getTeamItem(selectedTeam).observe(viewLifecycleOwner,{
            val results = it.results
            adapter.list = results
            rvResult.adapter = adapter
        })
    }

}