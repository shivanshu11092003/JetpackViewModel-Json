package com.example.basicapp.ViewModel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicapp.Models.Quote
import com.example.basicapp.Repository.TweetyRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class detailViewModel @Inject constructor(
    private val repository: TweetyRepo,
    private val savedStateHandle : SavedStateHandle)
    :ViewModel() {
    val quotes : StateFlow<List<Quote>>
        get() = repository.quotes

    init {
        viewModelScope.launch {
            val id = savedStateHandle.get<Int>("category")
            repository.getquotes(id!!)
        }
    }

}