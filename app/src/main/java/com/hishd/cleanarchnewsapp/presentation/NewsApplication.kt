package com.hishd.cleanarchnewsapp.presentation

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class NewsApplication: Application()
//Step 01: Creation of Application Context class and annotate with @HiltAndroidApp and add it to manifest