package com.example.retrofitmvvmmovie.view

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.example.retrofitmvvmmovie.R
import com.example.retrofitmvvmmovie.adapter.ResultAdapter
import com.example.retrofitmvvmmovie.databinding.ActivityMainBinding
import com.example.retrofitmvvmmovie.model.Result
import com.example.retrofitmvvmmovie.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity() {

    private var resultList: List<Result> = listOf()
    private lateinit var adapter: ResultAdapter
    private lateinit var recyclerView: RecyclerView
    private lateinit var swipeRefreshLayout: SwipeRefreshLayout
    private lateinit var mainActivityViewModel :MainActivityViewModel
    private lateinit var activityMainBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        activityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        mainActivityViewModel = ViewModelProvider.AndroidViewModelFactory(application).create(MainActivityViewModel::class.java)

        getMovieResult()

        swipeRefreshLayout = activityMainBinding.swipeRefresh
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary)
        swipeRefreshLayout.setOnRefreshListener { SwipeRefreshLayout.OnRefreshListener { getMovieResult() } }

    }

    private fun getMovieResult() {
        mainActivityViewModel.getAllMovieData().observe(this, Observer {
            resultList = it
            fillRecyclerView()
            swipeRefreshLayout.isRefreshing = false
        })
    }

    private fun fillRecyclerView() {
        recyclerView = activityMainBinding.recyclerView
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