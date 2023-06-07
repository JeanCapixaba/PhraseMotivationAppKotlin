package com.example.motivation.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.motivation.MotivationConstantes
import com.example.motivation.SecutiryPreferences
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        binding = ActivityUserBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        setContentView(binding.root)


        binding.btncompatSave.setOnClickListener {
            handleSave()
        }




    }



    private fun handleSave() {

        val name = binding.editName.text.toString()
        if (name != "") {

            SecutiryPreferences(context = this).storeString(
                MotivationConstantes.KEY.USER_NAME,
                name
            )

            finish()

        } else {
            Toast.makeText(this, "Seu nome é inválido", Toast.LENGTH_SHORT).show()
        }
    }

}