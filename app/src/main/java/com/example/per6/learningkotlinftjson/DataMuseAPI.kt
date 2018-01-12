package com.example.per6.learningkotlinftjson

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

/**
 * Created by per6 on 1/12/18.
 */
interface DataMuseAPI {

    @GET("words")
    fun getSoundsLike(@Query("sl") word : String) : Call<List<Word>>
}