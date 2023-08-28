package com.example.myapplicationdispaly.UI

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationdispaly.R
import com.example.myapplicationdispaly.Repository.PostRepository
import com.example.myapplicationdispaly.ViewModel.DisplayViewModel
import com.example.myapplicationdispaly.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    val postsViewModel: DisplayViewModel by viewModels()
    lateinit var binding: ActivityMain2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()
        postsViewModel.fetchedPosts()
        postsViewModel.postsLiveData.observe(this, Observer { postsList ->
            var postAdapt = PostAdapter(postsList ?: emptyList())
            binding.rvRecycler.layoutManager = LinearLayoutManager(this@MainActivity2)
            binding.rvRecycler.adapter = postAdapt

            Toast.makeText(
                baseContext,
                "fetched ${postsList?.size}posts",
                Toast.LENGTH_LONG
            ).show()
        })
        postsViewModel.errorLiveData.observe(this, Observer { error ->
            Toast.makeText(baseContext, error, Toast.LENGTH_LONG).show()
        })
    }
}