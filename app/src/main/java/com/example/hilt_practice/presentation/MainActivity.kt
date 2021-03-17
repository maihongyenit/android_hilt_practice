package com.example.hilt_practice.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.hilt_practice.R
import com.example.hilt_practice.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var fragmentFactory: MainFragmentFactory

    private lateinit var databinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        databinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        databinding.lifecycleOwner = this

        supportFragmentManager.apply {
            fragmentFactory = this@MainActivity.fragmentFactory
            beginTransaction()
                .replace(R.id.main_container, MainFragment::class.java, null)
                .commit()
        }
    }
}