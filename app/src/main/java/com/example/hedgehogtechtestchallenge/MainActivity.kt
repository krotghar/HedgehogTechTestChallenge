package com.example.hedgehogtechtestchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.hedgehogtechtestchallenge.view.MainFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(
                    R.id.fragmentContainerView,
                    MainFragment.newInstance(),
                    MainFragment::class.java.simpleName
                    )
                .commit()

        }
    }

}