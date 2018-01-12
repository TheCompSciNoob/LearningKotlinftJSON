package com.example.per6.learningkotlinftjson

import android.app.Application
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * Created by per6 on 1/12/18.
 */
class KotlinFtJsonApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        Realm.init(this)
        val config = RealmConfiguration.Builder()
                .name("kotlinftjson.realm")
                .deleteRealmIfMigrationNeeded()
                .build()
        Realm.setDefaultConfiguration(config)
    }
}