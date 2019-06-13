package com.maxproit.kotlin_mvvm.view

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.maxproit.kotlin_mvvm.R
import com.maxproit.kotlin_mvvm.model.Score
import com.maxproit.kotlin_mvvm.viewmodel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*
import org.greenrobot.eventbus.EventBus

class MainActivity : AppCompatActivity() {
    private var viewModel: MainActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProviders.of(this).get(MainActivityViewModel::class.java)

        initViews()
        initListener()
    }

    private fun initViews() {
        scoreTv.text = viewModel?.getScore().toString()
    }

    private fun initListener() {
        nextBtn.setOnClickListener {
            EventBus.getDefault().postSticky(Score(scoreTv.text))
            startActivity(Intent(this, NextActivity::class.java))
        }
        incBtn.setOnClickListener {
            viewModel?.incScore()
            scoreTv.text = viewModel?.getScore().toString()
        }
        decBtn.setOnClickListener {
            viewModel?.decScore()
            scoreTv.text = viewModel?.getScore().toString()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        viewModel?.saveScoreWhenExit()
        Toast.makeText(this, "Destroyed", Toast.LENGTH_LONG).show()
    }
}
