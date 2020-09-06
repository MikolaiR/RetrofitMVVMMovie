package com.example.retrofitmvvmmovie.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.retrofitmvvmmovie.R
import com.example.retrofitmvvmmovie.model.Result
import com.example.retrofitmvvmmovie.view.MovieDetailsActivity

class ResultAdapter(private val context: Context, private val resultList: List<Result>) :
    RecyclerView.Adapter<ResultAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imageViewPosterPath: ImageView = itemView.findViewById(R.id.imageView_poster_path)
        val textViewOriginalTitle: TextView = itemView.findViewById(R.id.textView_original_title)
        val textViewPopularity: TextView = itemView.findViewById(R.id.textView_popularity)

        init {
            itemView.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val result = resultList[position]
                    val intent = Intent(context, MovieDetailsActivity::class.java)
                    intent.putExtra("movieData", result)
                    context.startActivity(intent)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val view = layoutInflater.inflate(R.layout.recycler_item, parent, false)
        return CountryViewHolder(view)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val result = resultList[position]
        holder.textViewOriginalTitle.text = result.originalTitle
        holder.textViewPopularity.text = result.popularity.toString()
        val imagePath = "https://image.tmdb.org/t/p/w500${result.posterPath}"
        Glide.with(context).load(imagePath)
            .apply(
                RequestOptions()
                    .placeholder(R.drawable.loading_animation)
                    .error(R.drawable.error_image)
            ).into(holder.imageViewPosterPath)
    }
}