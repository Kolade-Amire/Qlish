package com.example.qlish.ui

import com.example.qlish.databinding.FragmentQuestionConfigBinding
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import com.example.qlish.R


class QuestionConfigFragment : Fragment(), AdapterView.OnItemSelectedListener{

    private var _binding: FragmentQuestionConfigBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val questionCountSpinner: Spinner = binding.questionCountSpinner
        questionCountSpinner.onItemSelectedListener = this
        val questionLevelSpinner: Spinner = binding.questionLevelSpinner
        questionLevelSpinner.onItemSelectedListener = this

// Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.question_count_items, R.layout.spinner_item_layout
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            questionCountSpinner.adapter = adapter
        }


        ArrayAdapter.createFromResource(
            requireContext(),
            R.array.question_level_items, R.layout.spinner_item_layout
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            questionLevelSpinner.adapter = adapter
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentQuestionConfigBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, postion: Int, id: Long) {
        val selectedItem = parent?.getItemAtPosition(postion)

    }

    override fun onNothingSelected(parent: AdapterView<*>?) {
        TODO("Not yet implemented")
    }
}