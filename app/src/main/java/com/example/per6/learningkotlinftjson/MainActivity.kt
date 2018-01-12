package com.example.per6.learningkotlinftjson

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import io.realm.Realm
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val baseUrl = "http://api.datamuse.com"
        val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api : DataMuseAPI = retrofit.create(DataMuseAPI::class.java)
        val call : Call<List<Word>> = api.getSoundsLike("success")
        call.enqueue(object : Callback<List<Word>> {
            override fun onFailure(call: Call<List<Word>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, t?.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Word>>?, response: Response<List<Word>>?) {
                Log.d("It Worked", "onResponse: ${response?.body()}")
            }
        })

        //database
        val realm = Realm.getDefaultInstance()
    }
}
