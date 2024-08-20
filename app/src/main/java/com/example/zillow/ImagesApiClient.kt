package com.example.zillow

import com.google.gson.annotations.SerializedName
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

class ImagesApiClient {

    val apiClient = Retrofit.Builder()
        .baseUrl("https://dog.ceo/api/breed/hound/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ImagesApi::class.java)

    interface ImagesApi {
        @GET("images")
        suspend fun getImages(): ImageData
    }

    data class ImageData(@SerializedName("message") val message: List<String>)
}