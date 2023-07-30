package com.example.qlish.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.qlish.databinding.FragmentProgressOverviewBinding

class ProgressOverviewFragment : Fragment() {
    private var _binding: FragmentProgressOverviewBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProgressOverviewBinding.inflate(inflater, container, false)
        return binding.root
    }
}