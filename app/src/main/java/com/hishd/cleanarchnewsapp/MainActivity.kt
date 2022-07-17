package com.hishd.cleanarchnewsapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.hishd.cleanarchnewsapp.databinding.ActivityMainBinding
import com.hishd.cleanarchnewsapp.presentation.viewmodel.NewsViewModel
import com.hishd.cleanarchnewsapp.presentation.viewmodel.NewsViewModelFactory
import dagger.hilt.EntryPoint
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    lateinit var viewModel: NewsViewModel
    @Inject
    lateinit var viewModelFactory: NewsViewModelFactory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupNavigationController()

        viewModel = ViewModelProvider(this, viewModelFactory)[NewsViewModel::class.java]
    }

    private fun setupNavigationController() {
        val navHost = supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val controller = navHost.navController

        binding.containerMenu.setupWithNavController(controller)
    }
}