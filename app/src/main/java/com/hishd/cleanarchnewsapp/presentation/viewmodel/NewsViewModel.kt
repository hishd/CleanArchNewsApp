package com.hishd.cleanarchnewsapp.presentation.viewmodel

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hishd.cleanarchnewsapp.data.model.APIResponse
import com.hishd.cleanarchnewsapp.data.util.Resource
import com.hishd.cleanarchnewsapp.domain.usecase.GetNewsHeadlinesUseCase
import kotlinx.coroutines.launch
import java.lang.Exception

class NewsViewModel(
    private val app: Application,
    private val getNewsHeadlinesUseCase: GetNewsHeadlinesUseCase
): AndroidViewModel(app) {
    private val newsResponse: MutableLiveData<Resource<APIResponse>> = MutableLiveData()
    val response: LiveData<Resource<APIResponse>> get() = newsResponse

    fun getNewsHeadlines(country: String, page: Int) {
        newsResponse.postValue(Resource.Loading())
        try {
            if(!isNetworkAvailable(app)) {
                newsResponse.postValue(Resource.Error(message = "Internet Connection not available"))
            }

            viewModelScope.launch {
                val newsHeadlines = getNewsHeadlinesUseCase.execute(country, page)
                newsResponse.postValue(newsHeadlines)
            }
        } catch (ex: Exception) {
            newsResponse.postValue(Resource.Error(message = ex.message.toString()))
        }
    }

    private fun isNetworkAvailable(context: Context?): Boolean {
        if (context == null) return false
        val connectivityManager = context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            val capabilities = connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
            if (capabilities != null) {
                when {
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                        return true
                    }
                    capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                        return true
                    }
                }
            }
        } else {
            val activeNetworkInfo = connectivityManager.activeNetworkInfo
            if (activeNetworkInfo != null && activeNetworkInfo.isConnected) {
                return true
            }
        }
        return false
    }
}