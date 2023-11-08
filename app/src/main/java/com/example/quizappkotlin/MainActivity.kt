package com.example.quizappkotlin

import com.example.quizappkotlin.databinding.ActivityMainBinding
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    lateinit var binding :ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //To hide status bar in the emulator
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN

        binding.startBtn.setOnClickListener(View.OnClickListener {
            if(binding.usernameEt.text.toString().isEmpty()){
                Toast.makeText(this,"Please enter your name",Toast.LENGTH_LONG).show()
            }else{
                val intent: Intent = Intent(this,QuizQuestionsActivity::class.java)
                println(binding.usernameEt.text.toString())
                intent.putExtra("username", binding.usernameEt.text.toString())
                startActivity(intent)
                finish()
            }
        })

    }
}