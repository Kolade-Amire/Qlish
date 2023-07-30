package com.example.qlish.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.qlish.databinding.FragmentWordOfTheDayBinding


class WordOfTheDayFragment : Fragment() {
    private var _binding: FragmentWordOfTheDayBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentWordOfTheDayBinding.inflate(inflater, container, false)
        return binding.root
    }
}