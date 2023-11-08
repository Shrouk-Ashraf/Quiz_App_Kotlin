package com.example.quizappkotlin

import android.content.Intent
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.quizappkotlin.data.*
import com.example.quizappkotlin.databinding.*

class QuizQuestionsActivity : AppCompatActivity() , View.OnClickListener {
    lateinit var binding : ActivityQuizQuestionsBinding
    var username :String? = null
    var currentPosition :Int = 0
    var questionList :ArrayList<QuestionModel>? = null
    var selectedAnswer: Int = -1
    var correctAnswers:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizQuestionsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = intent.getStringExtra("username")
        questionList = Constants.getQuestions()
        getQuestion()

        binding.answer1Tv.setOnClickListener(this)
        binding.answer2Tv.setOnClickListener(this)
        binding.answer3Tv.setOnClickListener(this)
        binding.answer4Tv.setOnClickListener(this)

        binding.submitBtn.setOnClickListener(this)

    }

    private fun getQuestion(){
        val question:QuestionModel = questionList!![currentPosition]
        println(question)
        setDefaultButtonView()
        if(currentPosition+1 == questionList!!.size){
            binding.submitBtn.text = "Finish"
        }else{
            binding.submitBtn.text = "Submit"
        }
        binding.progressIndicator.progress = question.id
        binding.questionNumberTv.text = "Question ${question.id}/${questionList!!.size}"
        binding.questionTv.text = question.question
        binding.answer1Tv.text = question.answers[0]
        binding.answer2Tv.text = question.answers[1]
        binding.answer3Tv.text = question.answers[2]
        binding.answer4Tv.text = question.answers[3]
    }

    override fun onClick(view: View?) {
        when(view?.id){
            R.id.answer1_tv ->{
                selectedAnswer=0
                binding.answer1Tv.setTypeface(binding.answer1Tv.typeface,Typeface.BOLD)
                binding.answer1Tv.background =ContextCompat.getDrawable(this,R.drawable.selected_option_card)
            }
            R.id.answer2_tv ->{
                selectedAnswer=1
                binding.answer2Tv.setTypeface(binding.answer2Tv.typeface,Typeface.BOLD)
                binding.answer2Tv.background =ContextCompat.getDrawable(this,R.drawable.selected_option_card)
            }
            R.id.answer3_tv ->{
                selectedAnswer=2
                binding.answer3Tv.setTypeface(binding.answer3Tv.typeface,Typeface.BOLD)
                binding.answer3Tv.background =ContextCompat.getDrawable(this,R.drawable.selected_option_card)
            }
            R.id.answer4_tv ->{
                selectedAnswer=3
                binding.answer4Tv.setTypeface(binding.answer4Tv.typeface,Typeface.BOLD)
                binding.answer4Tv.background =ContextCompat.getDrawable(this,R.drawable.selected_option_card)
            }
            R.id.submit_btn ->{
                if(selectedAnswer == -1){
                    currentPosition++
                    if(currentPosition < questionList!!.size){
                        getQuestion()
                    }else{
                        val intent = Intent(this,ResultActivity::class.java)
                        intent.putExtra("username",username)
                        intent.putExtra("result", correctAnswers)
                        startActivity(intent)
                        finish()
                    }
                }else{
                    //user has selected an option
                    val question:QuestionModel = questionList!![currentPosition]
                    if(question!!.correctAnswer != selectedAnswer){
                        answerView(selectedAnswer,R.drawable.wrong_option_card)
                    }else{
                        correctAnswers++
                    }
                    answerView(question.correctAnswer, R.drawable.correct_option_card)
                    if(currentPosition == (questionList!!.size)-1){
                        binding.submitBtn.text = "Show Result"
                    }else{
                        binding.submitBtn.text = "Go to next question"
                    }
                    selectedAnswer = -1
                }
            }
        }
    }

    private fun setDefaultButtonView(){
        val options =ArrayList<TextView>()
        options.add(0,binding.answer1Tv)
        options.add(1,binding.answer2Tv)
        options.add(2,binding.answer3Tv)
        options.add(3,binding.answer4Tv)
        for (option in options){
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,R.drawable.default_option_card)
        }
    }

    private fun answerView(answerIndex:Int, drawableView:Int){
        when(answerIndex){
            0-> binding.answer1Tv.background =ContextCompat.getDrawable(this,drawableView)
            1-> binding.answer2Tv.background =ContextCompat.getDrawable(this,drawableView)
            2-> binding.answer3Tv.background =ContextCompat.getDrawable(this,drawableView)
            3-> binding.answer4Tv.background =ContextCompat.getDrawable(this,drawableView)
        }
    }
}