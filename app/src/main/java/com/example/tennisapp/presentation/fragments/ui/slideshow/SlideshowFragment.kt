package com.example.tennisapp.presentation.fragments.ui.slideshow

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.tennisapp.databinding.FragmentSlideshowBinding

class SlideshowFragment : Fragment() {

    private lateinit var binding : FragmentSlideshowBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentSlideshowBinding.inflate(inflater,container,false)
        return binding.root
    }
}