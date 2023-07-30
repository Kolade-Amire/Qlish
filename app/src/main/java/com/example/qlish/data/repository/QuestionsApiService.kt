package com.example.qlish.data.repository

import com.example.qlish.model.Question
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface QuestionsApi {

    @GET("question-level/{questionLevel}/{questionCount}")
    suspend fun getQuestionsByLevel(@Path("questionLevel") questionLevel:String, @Path("questionCount") questionCount: Int): Response<List<Question>>


    @GET("{questionLevel}/{questionTopic}/{questionCount}")
    suspend fun getQuestionsByTopic(@Path("questionTopic") questionTopic:String, @Path("questionCount") questionCount: Int): Response<List<Question>>

    @GET("/{questionLevel}/{questionTopic}/{questionCount}")
    suspend fun getQuestionsByQuestionLevelAndTopic(@Path("questionLevel") questionLevel:String, @Path("questionTopic") questionTopic:String, @Path("questionCount") questionCount: Int): Response<List<Question>>

}

object GrammarRetrofitClient{
    val service: QuestionsApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8080/api/questions/grammar/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(QuestionsApi::class.java)
    }
}

object VocabularyRetrofitClient{
    val service: QuestionsApi by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("http://localhost:8080/api/questions/vocabulary/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        retrofit.create(QuestionsApi::class.java)
    }
}

