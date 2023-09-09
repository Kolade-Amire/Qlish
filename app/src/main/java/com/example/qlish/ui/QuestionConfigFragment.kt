package com.example.qlish.ui

import com.example.qlish.databinding.FragmentQuestionConfigBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.navigation.fragment.findNavController
import com.example.qlish.R
import com.example.qlish.data.configData
import com.example.qlish.data.questionCountList


class QuestionConfigFragment : Fragment(), AdapterView.OnItemSelectedListener {

    private var _binding: FragmentQuestionConfigBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionConfigBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //get arguments
        val args = QuestionConfigFragmentArgs.fromBundle(requireArguments())
        val questionClassArg = args.questionClass


        //navController
        val navController = findNavController()
        val action = QuestionConfigFragmentDirections.actionQuestionConfigFragmentToTestFragment()

        initializePicker() //number picker initialized
        initializeSpinner(questionClassArg)//setupSpinner


        binding.numberPicker.setOnValueChangedListener { _, _, newVal ->
            val selectedValue = questionCountList[newVal]
        }

        //startButton OnClickListener
        binding.buttonStartTest.setOnClickListener {
            navController.navigate(action)
        }

    }

    private fun initializePicker() {
        //setup number picker
        val questionCountPicker = binding.numberPicker
        questionCountPicker.minValue = 0
        questionCountPicker.maxValue = questionCountList.size - 1
        questionCountPicker.displayedValues = questionCountList
    }

    private fun initializeSpinner(questionClass: String) {

        val testChoiceSpinner = binding.questionLevelSpinner

        if (questionClass == configData["Random"]) {
            binding.questionLevelHeader.text = getString(R.string.question_topic_label)
            binding.levelInstructionText.text = getString(R.string.text_choose_test_topic)

            ArrayAdapter.createFromResource(
                requireContext(), R.array.question_topic_item, R.layout.spinner_item
            ).also { arrayAdapter ->
                arrayAdapter.setDropDownViewResource(R.layout.spinner_item_dropdown)
                testChoiceSpinner.adapter = arrayAdapter
            }
        } else {
            ArrayAdapter.createFromResource(
                requireContext(), R.array.question_level_items, R.layout.spinner_item
            ).also { arrayAdapter ->
                arrayAdapter.setDropDownViewResource(R.layout.spinner_item_dropdown)
                testChoiceSpinner.adapter = arrayAdapter
            }

        }

    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, postion: Int, id: Long) {
        val selectedItem = parent?.getItemAtPosition(postion)


    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}