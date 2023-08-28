package com.example.myapplicationdispaly.ViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope  //
import com.example.myapplicationdispaly.Model.Post
import com.example.myapplicationdispaly.Repository.PostRepository
import kotlinx.coroutines.launch

class DisplayViewModel() : ViewModel() {
    var postsRepo=PostRepository()
    var postsLiveData=MutableLiveData<List<Post>>()
    var errorLiveData=MutableLiveData<String>()

    fun fetchedPosts(){
        viewModelScope.launch {
            val response=postsRepo.getPosts()
            if(response.isSuccessful){
                val postsList=response.body()?: emptyList()
                postsLiveData.postValue(postsList as
                List<Post>)
            }
            else{
                errorLiveData.postValue(response.errorBody()?.string())
            }
        }
    }
}
