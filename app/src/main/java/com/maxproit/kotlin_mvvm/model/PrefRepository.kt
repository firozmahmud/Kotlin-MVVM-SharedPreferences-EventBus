package com.maxproit.kotlin_mvvm.model

import android.app.Application
import com.maxproit.kotlin_mvvm.preferences.SharedPref

class PrefRepository(private val app: Application) {

    fun saveScore(score: Int) {
        SharedPref(app).saveScore(score)
    }

    fun getScore(): Int? {
        return SharedPref(app).getScore()
    }
}