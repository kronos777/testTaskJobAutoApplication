package com.example.workautoapplication.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.workautoapplication.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), AutoItemFragment.OnEditingFinishedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    override fun onEditingFinished() {
        supportFragmentManager.popBackStack()
    }
}