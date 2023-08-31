package com.example.qlish.data.network

import com.example.qlish.model.Question
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path


const val BASE_URl = "http://localhost:8080/api/questions"


interface QuestionsApiService {
    @GET("question-level/{questionLevel}/{questionCount}")
    suspend fun getQuestionsByLevel(@Path("questionLevel") questionLevel:String, @Path("questionCount") questionCount: Int): Response<List<Question>>


    @GET("{questionLevel}/{questionTopic}/{questionCount}")
    suspend fun getQuestionsByTopic(@Path("questionTopic") questionTopic:String, @Path("questionCount")questionCount: Int): Response<List<Question>>

    @GET("/{questionLevel}/{questionTopic}/{questionCount}")
//    @Headers("Accept:application/json", "Content-Type:application/json")
    suspend fun getQuestionsByQuestionLevelAndTopic(@Path("questionLevel") questionLevel:String, @Path("questionTopic") questionTopic:String, @Path("questionCount") questionCount: Int): Response<List<Question>>

}




object GrammarApi {
   private val grammarRetrofitBuilder by lazy {
       val logging = HttpLoggingInterceptor()
       logging.setLevel(HttpLoggingInterceptor.Level.BODY)
       val client = OkHttpClient.Builder()
           .addInterceptor(logging)
           .build()
       Retrofit.Builder()
           .baseUrl("${BASE_URl}/grammar/")
           .addConverterFactory(GsonConverterFactory.create())
           .client(client)
           .build()
   }
    val retrofitService:QuestionsApiService by lazy {
        grammarRetrofitBuilder.create(QuestionsApiService::class.java)
    }
}

object VocabularyApi {
    private val vocabularyRetrofitBuilder by lazy {
        val logging = HttpLoggingInterceptor()
        logging.setLevel(HttpLoggingInterceptor.Level.BODY)
        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()
        Retrofit.Builder()
            .baseUrl("${BASE_URl}/vocabulary/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }

    val retrofitService:QuestionsApiService by lazy {
        vocabularyRetrofitBuilder.create(QuestionsApiService::class.java)
    }
}