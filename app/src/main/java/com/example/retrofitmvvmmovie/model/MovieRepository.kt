package com.example.retrofitmvvmmovie.model

import android.app.Application
import android.util.Log
import androidx.lifecycle.MutableLiveData
import com.example.retrofitmvvmmovie.R
import com.example.retrofitmvvmmovie.service.RetrofitInstance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieRepository(private val application: Application) {

    private var results: List<Result> = listOf()
    private val mutableLiveData = MutableLiveData<List<Result>>()

    fun getMutableLiveData(): MutableLiveData<List<Result>> {
        val movieApiService = RetrofitInstance().getService()
        val call: Call<MoviesApiResponse> =
            movieApiService.getMovieRest(application.applicationContext.getString(R.string.api_key))
        call.enqueue(object : Callback<MoviesApiResponse> {
            override fun onFailure(call: Call<MoviesApiResponse>, t: Throwable) {
            }

            override fun onResponse(
                call: Call<MoviesApiResponse>,
                response: Response<MoviesApiResponse>
            ) {
                val movieApiResponse = response.body()
                Log.i("result", "onResponse: ON")
                if (movieApiResponse?.results != null) {
                    results = movieApiResponse.results
                    mutableLiveData.value = results
                }
            }
        })
        return mutableLiveData
    }
}
