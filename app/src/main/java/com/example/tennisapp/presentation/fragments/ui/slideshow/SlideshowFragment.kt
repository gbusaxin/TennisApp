package com.example.tennisapp.presentation.fragments.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tennisapp.databinding.FragmentSlideshowBinding
import com.example.tennisapp.presentation.adapters.ViewPagerAdapter

class SlideshowFragment : Fragment() {

    private lateinit var binding: FragmentSlideshowBinding
    private lateinit var adapter: ViewPagerAdapter
    private lateinit var fixtureFragment: FixtureFragment
    private lateinit var resultFragment: ResultFragment

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        adapter = ViewPagerAdapter(childFragmentManager)
        fixtureFragment = FixtureFragment()
        resultFragment = ResultFragment()
        binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewPager = binding.viewPager
        val tabs = binding.tabs
        adapter.addFragment(fixtureFragment,"Будущие матчи")
        adapter.addFragment(resultFragment,"Результаты")
        viewPager.adapter = adapter
        tabs.setupWithViewPager(viewPager)
    }
}