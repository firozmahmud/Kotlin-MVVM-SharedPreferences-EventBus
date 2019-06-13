package com.maxproit.kotlin_mvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.maxproit.kotlin_mvvm.preferences.SharedPref
import kotlin.jvm.internal.Ref

class MainActivityViewModel(application: Application) : AndroidViewModel(application) {
    private var score = 0
    private var app: Application? = null

    init {
        score = SharedPref(application).getScore()
        app = application
    }

    fun incScore() {
        score++
    }

    fun decScore() {
        score--
    }

    fun getScore(): Int {
        return score
    }

    fun saveScoreWhenExit() {
        app?.let { SharedPref(it).saveScore(score) }
    }
}
