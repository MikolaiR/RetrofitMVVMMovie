package com.example.retrofitmvvmmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.retrofitmvvmmovie.R
import com.example.retrofitmvvmmovie.databinding.ActivityMovieDetailsBinding
import com.example.retrofitmvvmmovie.model.Result

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var result: Result
    private lateinit var activityMovieDetailsBinding: ActivityMovieDetailsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        activityMovieDetailsBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_movie_details)

        val intent = intent
        if (intent != null && intent.hasExtra("movieData")) {
            result = intent.getParcelableExtra("movieData")!!
            activityMovieDetailsBinding.result = result
        }

    }
}