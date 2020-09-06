package com.example.retrofitmvvmmovie.service

import com.example.retrofitmvvmmovie.model.MoviesApiResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

//"3/movie/popular?api_key=f5ab4198923700fc46e90cd850ea5a3f&language=en-US&page=1"

interface MovieApiService {

    @GET("movie/popular")
    fun getMovieRest(@Query("api_key") apiKey:String): Call<MoviesApiResponse>
}