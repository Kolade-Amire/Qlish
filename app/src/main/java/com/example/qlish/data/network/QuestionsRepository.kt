package com.example.qlish.data.network

import com.example.qlish.model.Question
import retrofit2.HttpException
import retrofit2.Response

class QuestionsRepository {

    suspend fun getQuestionsByLevel(questionClass:String, level: String, count: Int): Response<List<Question>> {
        val response = when(questionClass) {
            "grammar" -> GrammarApi.retrofitService.getQuestionsByLevel(level, count)
            else -> {
                VocabularyApi.retrofitService.getQuestionsByLevel(level, count)
            }
        }
        return response
    }

    suspend fun getQuestionsByTopic(questionClass: String, topic:String, count: Int): Response<List<Question>> {

        val response = when(questionClass){
            "grammar" -> GrammarApi.retrofitService.getQuestionsByTopic(topic, count)
            else -> {VocabularyApi.retrofitService.getQuestionsByTopic(topic, count)
            }
        }

        return response
    }


    suspend fun getQuestionsByLevelAndTopic(questionClass: String, level:String, topic:String, count: Int): Response<List<Question>> {
        val response = when(questionClass){
            "grammar" -> GrammarApi.retrofitService.getQuestionsByQuestionLevelAndTopic(level,topic,count)
            else -> {VocabularyApi.retrofitService.getQuestionsByQuestionLevelAndTopic(level,topic,count)
            }
        }
        return response
    }

}