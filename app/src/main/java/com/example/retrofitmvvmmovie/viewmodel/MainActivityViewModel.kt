package com.example.retrofitmvvmmovie.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.retrofitmvvmmovie.model.MovieRepository
import com.example.retrofitmvvmmovie.model.Result

class MainActivityViewModel(application: Application): AndroidViewModel(application) {

    private val movieRepository = MovieRepository(application)

    fun getAllMovieData():LiveData<List<Result>>{
        return  movieRepository.getMutableLiveData()
    }

}