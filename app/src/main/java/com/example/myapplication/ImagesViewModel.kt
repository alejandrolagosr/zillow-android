package com.example.myapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ImagesViewModel: ViewModel() {

    private val imagesApiClient = ImagesApiClient()

    val images: MutableLiveData<List<String>> = MutableLiveData()

     fun getImages() {
        viewModelScope.launch(Dispatchers.IO) {
            images.postValue(imagesApiClient.apiClient.getImages().message)
        }
    }
}