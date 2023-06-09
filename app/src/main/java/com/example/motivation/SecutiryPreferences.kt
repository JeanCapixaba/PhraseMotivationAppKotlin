package com.example.motivation

import android.content.Context
import android.content.SharedPreferences

class SecutiryPreferences (context: Context) {

    private val secutiry: SharedPreferences = context.getSharedPreferences("Motivation", Context.MODE_PRIVATE)

    fun storeString(key: String, str: String){
        secutiry.edit().putString(key, str).apply()
    }

    fun getString(key: String) : String {
        return secutiry.getString(key, "") ?: ""
    }


}