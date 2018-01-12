package com.example.per6.learningkotlinftjson

import io.realm.RealmModel

/**
 * Created by per6 on 1/12/18.
 */
data class Word(var word : String = "", var score : Int = 0, var numSyllables : Int = 0) : RealmModel {
}