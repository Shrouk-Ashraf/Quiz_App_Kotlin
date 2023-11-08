package com.example.quizappkotlin.data

data class QuestionModel (
            val id:Int,
            val question: String,
            val answers : ArrayList<String>,
            val correctAnswer :Int,
        )