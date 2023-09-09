package com.example.qlish.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.qlish.R
import com.example.qlish.data.configData
import com.example.qlish.databinding.FragmentDashboardBinding
import com.example.qlish.databinding.FragmentTakeATestBinding


class TakeATest : Fragment() {

    private var _binding: FragmentTakeATestBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentTakeATestBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        //navController
        val navController = findNavController()



        binding.actionGrammar.setOnClickListener {
            navController.navigate(TakeATestDirections.actionTakeATestToQuestionConfigFragment(
                configData["Grammar"].toString()))
        }
        binding.actionVocabulary.setOnClickListener {
            navController.navigate(TakeATestDirections.actionTakeATestToQuestionConfigFragment(
                configData["Vocabulary"].toString()))

        }
        binding.actionRandom.setOnClickListener {
            navController.navigate(TakeATestDirections.actionTakeATestToQuestionConfigFragment(
                configData["Random"].toString()))
        }
    }

}