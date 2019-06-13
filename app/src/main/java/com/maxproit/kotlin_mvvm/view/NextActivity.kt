package com.maxproit.kotlin_mvvm.view

import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.maxproit.kotlin_mvvm.R
import com.maxproit.kotlin_mvvm.model.Score
import com.maxproit.kotlin_mvvm.viewmodel.NextActivityViewModel
import kotlinx.android.synthetic.main.activity_next.*
import org.greenrobot.eventbus.EventBus
import org.greenrobot.eventbus.Subscribe
import org.greenrobot.eventbus.ThreadMode

class NextActivity : AppCompatActivity() {
    private var viewModel: NextActivityViewModel? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        viewModel = ViewModelProviders.of(this).get(NextActivityViewModel::class.java)
        EventBus.getDefault().register(this)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            android.R.id.home -> {
                finish()
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    @Subscribe(threadMode = ThreadMode.MAIN, sticky = true)
    fun onEvent(score: Score) {
        scoreTv.text = score.score
    }

}
