package com.example.myapplicationdispaly.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope  //
import com.example.myapplicationdispaly.Model.Post
import com.example.myapplicationdispaly.Repository.PostRepository
import kotlinx.coroutines.launch

class DisplayViewModel(private val repository: PostRepository) : ViewModel() {

    private val _posts = MutableLiveData<List<Post>>()
    val posts: LiveData<List<Post>> = _posts

    init {
        viewModelScope.launch {
            val fetchedPosts = repository.getPosts()
            _posts.value = fetchedPosts
        }
    }
}
