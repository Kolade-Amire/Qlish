package com.example.qlish.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qlish.databinding.FragmentTestBinding

class TestFragment : Fragment(){

    private var _binding: FragmentTestBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.questionsRecyclerView.layoutManager = LinearLayoutManager(context)
//        binding.questionsRecyclerView.adapter = QuestionAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTestBinding.inflate(inflater, container, false)
        return binding.root
    }
}