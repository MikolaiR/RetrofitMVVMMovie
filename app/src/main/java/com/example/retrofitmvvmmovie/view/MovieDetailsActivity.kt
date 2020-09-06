package com.example.retrofitmvvmmovie.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.retrofitmvvmmovie.R
import com.example.retrofitmvvmmovie.model.Result

class MovieDetailsActivity : AppCompatActivity() {

    private lateinit var result: Result
    private lateinit var posterImageView:ImageView
    private lateinit var posterPath:String
    private lateinit var titleTextView:TextView
    private lateinit var voteCountTextView:TextView
    private lateinit var overviewTextView:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_details)

        posterImageView = findViewById(R.id.posterImageView)
        titleTextView = findViewById(R.id.titleTextView)
        voteCountTextView = findViewById(R.id.voteCountTextView)
        overviewTextView = findViewById(R.id.overviewTextView)

        val intent = intent
        if (intent != null && intent.hasExtra("movieData")){
            result = intent.getParcelableExtra<Result>("movieData")!!
            Toast.makeText(this, result.originalTitle, Toast.LENGTH_SHORT).show()
            val imagePath = "https://image.tmdb.org/t/p/w500${result.posterPath}"
            voteCountTextView.text = result.voteCount.toString()
            overviewTextView.text = result.overview
            titleTextView.text = result.originalTitle
            Glide.with(this).load(imagePath)
                .apply(
                    RequestOptions()
                        .placeholder(R.drawable.loading_animation)
                        .error(R.drawable.error_image)
                ).into(posterImageView)
        }

    }
}