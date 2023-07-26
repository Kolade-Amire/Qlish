package com.example.qlish.model



data class Question(
    val id: Id,
    val questionBody: String,
    val options: Map<String, String>,
    val questionClass: String,
    val questionLevel: String,
    val questionTopic: String,
    val answer: String
)

data class Id(
    val timestamp: Long,
    val date: String
)
