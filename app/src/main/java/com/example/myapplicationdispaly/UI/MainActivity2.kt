package com.example.myapplicationdispaly.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationdispaly.R
import com.example.myapplicationdispaly.Repository.PostRepository
import com.example.myapplicationdispaly.ViewModel.DisplayViewModel

class MainActivity2 : AppCompatActivity() {

    private lateinit var viewModel: DisplayViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val repository = PostRepository()
        viewModel = ViewModelProvider(this).get(DisplayViewModel::class.java)

        val postAdapter = PostAdapter()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerView)

        recyclerView.adapter = postAdapter

        viewModel.posts.observe(this, Observer { posts ->
            postAdapter.submitList(posts)
        })
    }
}
