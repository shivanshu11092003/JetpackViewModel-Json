package com.example.basicapp.ViewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicapp.Repository.TweetyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CategoryViewModel @Inject constructor(private val repository: TweetyRepo) :ViewModel() {
    val categories : StateFlow<List<Int>>
        get() = repository.categories

    init {
        viewModelScope.launch {
            repository.getcategory()
        }
    }

}