package com.example.qlish.data

import com.example.qlish.model.Question
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class QuestionsRepository (private val dataSource: QuestionsRemoteDataSource) {

    suspend fun getGrammarQuestionsByLevel(questionLevel:String, questionCount:Int): Flow<Result<List<Question>>> = flow {
        emit(Result.Loading)
        try {
            val response = dataSource.getGrammarQuestionsByLevel(questionLevel, questionCount)
            if (response.isSuccessful) {
                val questions = response.body() ?: emptyList()
                emit(Result.Success(questions))
            } else {
                emit(Result.Error(Exception(response.message())))
            }
        } catch (e:Exception) {
            emit(Result.Error(e))
        }
    }


    suspend fun getGrammarQuestionsByTopic(questionTopic:String, questionCount:Int): Flow<Result<List<Question>>> = flow {
        emit(Result.Loading)
        try {
            val response = dataSource.getGrammarQuestionsByTopic(questionTopic, questionCount)
            if (response.isSuccessful) {
                val questions = response.body() ?: emptyList()
                emit(Result.Success(questions))
            } else {
                emit(Result.Error(Exception(response.message())))
            }
        } catch (e:Exception) {
            emit(Result.Error(e))
        }
    }

    suspend fun getGrammarQuestionsByLevelAndTopic(questionLevel:String, questionTopic: String, questionCount:Int): Flow<Result<List<Question>>> = flow {
        emit(Result.Loading)
        try {
            val response = dataSource.getGrammarQuestionsByLevelAndTopic(questionLevel, questionTopic, questionCount)
            if (response.isSuccessful) {
                val questions = response.body() ?: emptyList()
                emit(Result.Success(questions))
            } else {
                emit(Result.Error(Exception(response.message())))
            }
        } catch (e:Exception) {
            emit(Result.Error(e))
        }
    }



    suspend fun getVocabularyQuestionsByLevel(questionLevel:String, questionCount:Int): Flow<Result<List<Question>>> = flow {
        emit(Result.Loading)
        try {
            val response = dataSource.getVocabularyQuestionsByLevel(questionLevel, questionCount)
            if (response.isSuccessful) {
                val questions = response.body() ?: emptyList()
                emit(Result.Success(questions))
            } else {
                emit(Result.Error(Exception(response.message())))
            }
        } catch (e:Exception) {
            emit(Result.Error(e))
        }
    }


    suspend fun getVocabularyQuestionsByTopic(questionTopic:String, questionCount:Int): Flow<Result<List<Question>>> = flow {
        emit(Result.Loading)
        try {
            val response = dataSource.getVocabularyQuestionsByTopic(questionTopic, questionCount)
            if (response.isSuccessful) {
                val questions = response.body() ?: emptyList()
                emit(Result.Success(questions))
            } else {
                emit(Result.Error(Exception(response.message())))
            }
        } catch (e:Exception) {
            emit(Result.Error(e))
        }
    }

    suspend fun getVocabularyQuestionsByLevelAndTopic(questionLevel:String, questionTopic: String, questionCount:Int): Flow<Result<List<Question>>> = flow {
        emit(Result.Loading)
        try {
            val response = dataSource.getVocabularyQuestionsByLevelAndTopic(questionLevel, questionTopic, questionCount)
            if (response.isSuccessful) {
                val questions = response.body() ?: emptyList()
                emit(Result.Success(questions))
            } else {
                emit(Result.Error(Exception(response.message())))
            }
        } catch (e:Exception) {
            emit(Result.Error(e))
        }
    }

}

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()
}