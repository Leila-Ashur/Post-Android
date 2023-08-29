package com.example.myapplicationdispaly.UI

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplicationdispaly.Model.Post
import com.example.myapplicationdispaly.databinding.ListItemBinding


class PostsAdapter(var postslist:List<Post>):RecyclerView.Adapter<PostsViewHolder>() {
    lateinit var binding: ListItemBinding
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostsViewHolder {
        val binding=ListItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return PostsViewHolder(binding)

    }

    override fun onBindViewHolder(holder: PostsViewHolder, position: Int) {
        var currentPost=postslist[position]
        val binding=holder.binding
        binding.tvTitle.text=currentPost.id.toString()
        binding.tvBody.text=currentPost.title
        binding.tvDescription.text=currentPost.body
    }

    override fun getItemCount(): Int {
        return postslist.size
    }
}
class PostsViewHolder(var binding: ListItemBinding):RecyclerView.ViewHolder(binding.root){

}
