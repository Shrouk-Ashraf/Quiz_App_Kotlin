package com.example.quizappkotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.quizappkotlin.data.*
import com.example.quizappkotlin.databinding.*


class ResultActivity : AppCompatActivity() {
    lateinit var binding: ActivityResultBinding
    var username: String? = null
    var result:Int? = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        username = intent.getStringExtra("username")
        result = intent.getIntExtra("result",-1)

        binding.usernameResult.text = username
        binding.score.text = "Your score is $result/${Constants.getQuestions().size}"

        binding.retryBtn.setOnClickListener(View.OnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        })
    }
}