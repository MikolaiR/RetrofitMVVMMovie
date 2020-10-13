package com.example.retrofitmvvmmovie.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

private const val BASE_URL = "https://api.themoviedb.org/3/"

class RetrofitInstance {
        private var retrofit: Retrofit? = null
        fun getService(): MovieApiService {
            if (retrofit == null){
                retrofit = Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl(BASE_URL)
                    .build()
            }
            return retrofit?.create(MovieApiService::class.java)!!
        }
}