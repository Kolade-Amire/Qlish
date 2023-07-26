package com.example.qlish.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qlish.databinding.QuestionListItemBinding
import com.example.qlish.model.Question

class QuestionAdapter(val context: Context, val question: List<Question>) :
    RecyclerView.Adapter<QuestionAdapter.ViewHolder>() {


    inner class ViewHolder(binding: QuestionListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        val questionText = binding.questionText
        val optionA = binding.optionA
        val optionB = binding.optionB
        val optionC = binding.optionC
        val optionD = binding.optionD
        val optionE = binding.optionE

        var notePosition = 0

        init {
            // Define click listener for the ViewHolder's View

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            QuestionListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.questionText.text = question[position].questionBody
        holder.optionA.text = question[position].options["A"]
        holder.optionB.text = question[position].options["B"]
        holder.optionC.text = question[position].options["C"]
        holder.optionD.text = question[position].options["D"]
        holder.optionE.text = question[position].options["E"]
    }

    override fun getItemCount() = question.size

}