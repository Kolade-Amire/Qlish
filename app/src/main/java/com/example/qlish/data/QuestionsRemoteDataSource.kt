package com.example.qlish.data

import com.example.qlish.model.Question
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import retrofit2.Response

class QuestionsRemoteDataSource (private val ioDispatcher: CoroutineDispatcher) {


    //Grammar
    suspend fun getGrammarQuestionsByLevel(questionLevel:String, questionCount: Int): Response<List<Question>> =
        withContext(ioDispatcher){
            GrammarRetrofitClient.service.getQuestionsByLevel(questionLevel, questionCount)
        }

    suspend fun getGrammarQuestionsByTopic(questionTopic:String, questionCount: Int): Response<List<Question>> =
        withContext(ioDispatcher){
            GrammarRetrofitClient.service.getQuestionsByTopic(questionTopic, questionCount)
        }

    suspend fun getGrammarQuestionsByLevelAndTopic(questionLevel:String, questionTopic:String, questionCount: Int): Response<List<Question>> =
        withContext(ioDispatcher){
            GrammarRetrofitClient.service.getQuestionsByQuestionLevelAndTopic(questionLevel, questionTopic, questionCount)
        }


    //Vocabulary
    suspend fun getVocabularyQuestionsByLevel(questionLevel:String, questionCount: Int): Response<List<Question>> =
        withContext(ioDispatcher){
            VocabularyRetrofitClient.service.getQuestionsByLevel(questionLevel, questionCount)
        }

    suspend fun getVocabularyQuestionsByTopic(questionTopic:String, questionCount: Int): Response<List<Question>> =
        withContext(ioDispatcher){
            VocabularyRetrofitClient.service.getQuestionsByTopic(questionTopic, questionCount)
        }

    suspend fun getVocabularyQuestionsByLevelAndTopic(questionLevel:String, questionTopic:String, questionCount: Int): Response<List<Question>> =
        withContext(ioDispatcher){
            VocabularyRetrofitClient.service.getQuestionsByQuestionLevelAndTopic(questionLevel, questionTopic, questionCount)
        }
}

