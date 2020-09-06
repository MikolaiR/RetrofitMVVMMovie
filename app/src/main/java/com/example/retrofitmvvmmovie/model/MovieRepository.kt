package com.example.retrofitmvvmmovie.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmvvmmovie.R
import com.example.retrofitmvvmmovie.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(val application: Application) {

    private var results:List<Result> = listOf()
    private var mutableLiveData = MutableLiveData<List<Result>>()
   /* get() {
        val movieApiService = RetrofitInstance().getService()
        val call: Call<MoviesApiResponse> = movieApiService.getMovieRest(application.applicationContext.getString(R.string.api_key))
        call.enqueue(object : Callback<MoviesApiResponse> {
            override fun onFailure(call: Call<MoviesApiResponse>, t: Throwable) {
                TODO("Not yet implemented")
            }

            override fun onResponse(
                call: Call<MoviesApiResponse>,
                response: Response<MoviesApiResponse>
            ) {
                val movieInfo = response.body()
                Log.i("result", "onResponse: ON")
                if (movieInfo?.results != null) {
               //     resultList = movieInfo.results as List<Result>

                }
            }
        })
    }*/
}