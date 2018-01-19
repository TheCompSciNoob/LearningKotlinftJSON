package com.example.per6.learningkotlinftjson

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //wire widgets
        val adapter = WordAdapter(arrayListOf())
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val baseUrl = "http://api.datamuse.com"
        val retrofit : Retrofit = Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        val api : DataMuseAPI = retrofit.create(DataMuseAPI::class.java)
        val call : Call<List<Word>> = api.getSoundsLike("shock")
        call.enqueue(object : Callback<List<Word>> {
            override fun onFailure(call: Call<List<Word>>?, t: Throwable?) {
                Toast.makeText(this@MainActivity, t?.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Word>>?, response: Response<List<Word>>?) {
                Log.d("It Worked", "onResponse: ${response?.body()}")
                adapter.data = response?.body()!!
                adapter.notifyDataSetChanged()
            }
        })
    }
}
