package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.content.ContextCompat
import com.example.motivation.Mock
import com.example.motivation.MotivationConstantes
import com.example.motivation.Phrase
import com.example.motivation.R
import com.example.motivation.SecutiryPreferences
import com.example.motivation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding
    private var categoryId = MotivationConstantes.NUMBERS.ALL


    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityMainBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        //guardar nome de usuario

        handlerFilter(R.id.ic_all)
        handleNextPhrase()


        //eventos botões
        binding.btnNovaFrase.setOnClickListener(this)
        binding.icEmoji.setOnClickListener(this)
        binding.icSunny.setOnClickListener(this)
        binding.icAll.setOnClickListener(this)
        binding.textKotlin.setOnClickListener {
            startActivity(Intent(this, UserActivity::class.java))
        }


    }

    override fun onResume() {
        super.onResume()
        handleUserName()
    }



    private fun handleUserName() {
        val name =
            SecutiryPreferences(this).getString(MotivationConstantes.KEY.USER_NAME).toString()
        binding.textKotlin.text = "Olá, $name!"
    }


    override fun onClick(view: View) {

        if (view.id == R.id.btn_nova_frase) {
            handleNextPhrase()
        } else if (view.id in listOf(R.id.ic_all, R.id.ic_emoji, R.id.ic_sunny)){
                handlerFilter(view.id)
            }


    }

    private fun handlerFilter(id: Int) {

        binding.icAll.setColorFilter(ContextCompat.getColor(this, R.color.azul_escuro))
        binding.icEmoji.setColorFilter(ContextCompat.getColor(this, R.color.azul_escuro))
        binding.icSunny.setColorFilter(ContextCompat.getColor(this, R.color.azul_escuro))

        when (id) {
            R.id.ic_all -> {
                binding.icAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstantes.NUMBERS.ALL
            }
            R.id.ic_emoji -> {
                binding.icEmoji.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstantes.NUMBERS.EMOJI
            }
            R.id.ic_sunny -> {
                binding.icSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = MotivationConstantes.NUMBERS.SUNNY
            }
        }
    }

    private fun handleNextPhrase(){
        binding.textFrase.text = Mock().getPhrase(categoryId)
    }

}


