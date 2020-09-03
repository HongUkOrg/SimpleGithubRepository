package com.bleo.simplegithubserachapplication.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bleo.simplegithubserachapplication.R
import com.bleo.simplegithubserachapplication.main.MainFragment

class MainActivity : AppCompatActivity() {

    // MARK: - Initialize
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = supportFragmentManager.findFragmentById(R.id.contents)
        if (fragment == null) {
            supportFragmentManager.beginTransaction()
                    .replace(R.id.contents,
                        MainFragment.newInstance(), "MainView")
                    .commit()
        }

    }


}