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

    }

    override fun getItemCount() = question.size

}