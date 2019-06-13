package com.maxproit.kotlin_mvvm.viewmodel

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import com.maxproit.kotlin_mvvm.preferences.SharedPref

class NextActivityViewModel(application: Application) : AndroidViewModel(application) {
    private var app: Application? = null

    init {
        app = application
    }

    fun getScore(): Int? {
        return app?.let { SharedPref(it).getScore() }
    }
}