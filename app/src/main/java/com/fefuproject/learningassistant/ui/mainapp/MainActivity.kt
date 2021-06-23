package com.fefuproject.learningassistant.ui.mainapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.fefuproject.learningassistant.R
import com.fefuproject.learningassistant.databinding.ActivityMainBinding
import com.fefuproject.learningassistant.ui.login.view.LoginActivity
import com.google.android.material.appbar.MaterialToolbar
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_theory.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navController = findNavController(R.id.main_nav_host_fragment)
        navController.setGraph(R.navigation.main_navigation)

        val appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.navigation_home, R.id.navigation_materials, R.id.navigation_subjects, R.id.navigation_quiz, R.id.navigation_profile
            )
        )
//        setupActionBarWithNavController(navController, appBarConfiguration)
        binding.navView.setupWithNavController(navController)
    }



    fun getOut() {
        startActivity(Intent(this, LoginActivity::class.java))
        finish()
    }

}