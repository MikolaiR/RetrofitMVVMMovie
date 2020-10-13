package com.example.retrofitmvvmmovie.adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.retrofitmvvmmovie.R
import com.example.retrofitmvvmmovie.databinding.RecyclerItemBinding
import com.example.retrofitmvvmmovie.model.Result
import com.example.retrofitmvvmmovie.view.MovieDetailsActivity

class ResultAdapter(private val context: Context, private val resultList: List<Result>) :
    RecyclerView.Adapter<ResultAdapter.CountryViewHolder>() {

    inner class CountryViewHolder(val recyclerItemBinding: RecyclerItemBinding) :
        RecyclerView.ViewHolder(recyclerItemBinding.root) {

        init {
            recyclerItemBinding.root.setOnClickListener {
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
       val recyclerItemBinding = DataBindingUtil.inflate<RecyclerItemBinding>(LayoutInflater.from(parent.context),R.layout.recycler_item,parent,false)
        return CountryViewHolder(recyclerItemBinding)
    }

    override fun getItemCount(): Int {
        return resultList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        val result = resultList[position]

        holder.recyclerItemBinding.result = result
    }
}