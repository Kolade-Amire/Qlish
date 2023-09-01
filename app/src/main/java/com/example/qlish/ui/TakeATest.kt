package com.example.qlish.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.example.qlish.R
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

        val navController = findNavController()
        val action = TakeATestDirections.actionTakeATestToQuestionConfigFragment()

        binding.actionGrammar.setOnClickListener {
            action.arguments.putString("question_class", "grammar")
            navController.navigate(action)
        }
        binding.actionVocabulary.setOnClickListener {
            action.arguments.putString("question_class", "vocabulary")
            navController.navigate(action)

        }
        binding.actionRandom.setOnClickListener {
            action.arguments.putString("question_class", "random")
        }
    }

}