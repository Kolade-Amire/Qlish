package com.example.qlish.data.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qlish.data.network.QuestionsRepository
import com.example.qlish.model.Question
import kotlinx.coroutines.launch
import retrofit2.HttpException

val TAG = QuestionViewModel::class.simpleName

class QuestionViewModel : ViewModel() {
    private val repository = QuestionsRepository()
    private val _questionData = MutableLiveData<List<Question>>()
    val questionData: LiveData<List<Question>> = _questionData

    private val _status = MutableLiveData<String>()
    val status: LiveData<String> = _status


    private fun getQuestionsByLevel(
        questionClass: String,
        questionLevel: String,
        questionCount: Int
    ) {
        viewModelScope.launch {
            try {
                val responseInstance =
                    repository.getQuestionsByLevel(questionClass, questionLevel, questionCount)
                if (responseInstance.isSuccessful) {
                    _questionData.postValue(responseInstance.body())
                    _status.postValue("Questions loaded successfully")
                }
            } catch (e: HttpException) {
                println(e.message)
                _status.postValue(e.message)
            }
        }

    }

    private fun getQuestionsByTopic(
        questionClass: String,
        questionTopic: String,
        questionCount: Int
    ) {
        viewModelScope.launch {
            try {
                val responseInstance =
                    repository.getQuestionsByTopic(questionClass, questionTopic, questionCount)
                if (responseInstance.isSuccessful) {
                    _questionData.postValue(responseInstance.body())
                    _status.postValue("Questions loaded successfully")
                }
            } catch (e: HttpException) {
                println(e.message)
                _status.postValue(e.message)
            }
        }
    }

    private fun getQuestionsByLevelAndTopic(
        questionClass: String,
        questionLevel: String,
        questionTopic: String,
        questionCount: Int
    ) {
        viewModelScope.launch{
            try {
                val responseInstance =
                    repository.getQuestionsByLevelAndTopic(questionClass, questionLevel, questionTopic, questionCount)
                if (responseInstance.isSuccessful) {
                    _questionData.postValue(responseInstance.body())
                    _status.postValue("Questions loaded successfully")
                }
            } catch (e: HttpException) {
                println(e.message)
                _status.postValue(e.message)
            }
        }
    }


}