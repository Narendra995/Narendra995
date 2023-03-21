package com.example.first

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.coroutines.*
import retrofit2.Retrofit

import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContentView(R.layout.activity_main)

        val api= Retrofit.Builder()
            .baseUrl(BASEURL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(MyAPI::class.java)

        GlobalScope.launch(Dispatchers.IO) {
            val response=api.getComments()
            if(response.isSuccessful ){
                for (n in response.body()!!){
                    Log.e("Tag",n.email+ n.name)
                }

            }


        }

        }

    }
