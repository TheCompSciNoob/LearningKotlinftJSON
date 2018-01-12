package com.example.per6.learningkotlinftjson

import android.arch.lifecycle.ViewModel
import io.realm.Realm

/**
 * Created by per6 on 1/12/18.
 */
class WordViewModel : ViewModel() {

    private var results : RealmLiveData<Word>? = null
    private val realm = Realm.getDefaultInstance()

    fun getWordsFromDatabase() : RealmLiveData<Word> {
        if (results == null) {
            results = RealmLiveData(realm.where(Word::class.java).findAllAsync())
        }
        return results as RealmLiveData<Word>
    }
}