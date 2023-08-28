package com.example.myapplicationdispaly.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationdispaly.Model.Post
import com.example.myapplicationdispaly.databinding.ListItemBinding


class PostAdapter(var postsList:List<Post>PostAdapter):RecyclerView.Adapter<PostsViewHolder>(){
   lateinit var binding:ListItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding = ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        val currentPosts=postsList[position]
        val binding=holder.binding
        binding.tvTitle.text=currentPosts.id.toString()
    }

}