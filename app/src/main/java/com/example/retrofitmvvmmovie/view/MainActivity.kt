package com.example.retrofitmvvmmovie.view

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.retrofitmvvmmovie.R
import com.example.retrofitmvvmmovie.service.RetrofitInstance
import com.example.retrofitmvvmmovie.adapter.ResultAdapter
import com.example.retrofitmvvmmovie.model.MoviesApiResponse
import com.example.retrofitmvvmmovie.model.Result
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    private var resultList: List<Result> = listOf()
    private lateinit var adapter: ResultAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getMovieResult()

        swipeRefreshLayout = findViewById(R.id.swipeRefresh)
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary)
        swipeRefreshLayout.setOnRefreshListener { SwipeRefreshLayout.OnRefreshListener { getMovieResult() } }

    }

    private fun getMovieResult(): List<Result> {
        val movieApiService = RetrofitInstance().getService()
        val call: Call<MoviesApiResponse> = movieApiService.getMovieRest(getString(R.string.api_key))
        call.enqueue(object : Callback<MoviesApiResponse> {
            override fun onFailure(call: Call<MoviesApiResponse>, t: Throwable) {}
            override fun onResponse(
                call: Call<MoviesApiResponse>,
                response: Response<MoviesApiResponse>
            ) {
                val movieInfo = response.body()
                Log.i("result", "onResponse: ON")
                if (movieInfo?.results != null) {
                    resultList = movieInfo.results as List<Result>
                    for (result in resultList) {
                        Log.i("result", "onResponse: ${result.originalTitle}")
                    }
                    fillRecyclerView()

                    swipeRefreshLayout.isRefreshing = false
                }
            }
        })
        return resultList
    }

    private fun fillRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView)
        adapter = ResultAdapter(this@MainActivity, resultList)
        if (resources.configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {
            recyclerView.layoutManager = GridLayoutManager(this, 2)
        } else {
            recyclerView.layoutManager = GridLayoutManager(this, 4)
        }
        recyclerView.itemAnimator = DefaultItemAnimator()
        recyclerView.adapter = adapter
        adapter.notifyDataSetChanged()
    }

}