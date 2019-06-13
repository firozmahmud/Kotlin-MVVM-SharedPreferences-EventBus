package com.maxproit.kotlin_mvvm.preferences

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.maxproit.kotlin_mvvm.constants.AppConstants

class SharedPref(app: Application) {
    private var sp: SharedPreferences? = null

    init {
        sp = app.getSharedPreferences(AppConstants.PREF_KEY, Context.MODE_PRIVATE)
    }

    fun saveScore(score: Int) {
        sp?.edit()?.putInt(AppConstants.SCORE_KEY, score)?.apply()
    }

    fun getScore(): Int? {
        return sp?.getInt(AppConstants.SCORE_KEY, 0)
    }
}
