package com.example.basicapp.Repository

import com.example.basicapp.Api.TweetsyApi
import com.example.basicapp.Models.Quote
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class TweetyRepo @Inject constructor(private val tweetsyApi: TweetsyApi) {
//private val _categories ko private iss liye banya hai ki iska change keval tweeetrepo hi kar sake koi aur jagha se is pe chnage mat aye
    private val _categories = MutableStateFlow<List<Int>>(emptyList())
    val categories :StateFlow<List<Int>>
        get() = _categories


    private val _quotes = MutableStateFlow<List<Quote>>(emptyList())
    val quotes :StateFlow<List<Quote>>
        get() = _quotes


    suspend fun getcategory(){
        val response = tweetsyApi.getccategory()
        if (response.isSuccessful && response.body() != null){
            _categories.emit(response.body()!!)

        }
    }
    suspend fun getquotes(id: Int){
        val ids= id.toString() // your string id here

        val response = tweetsyApi.getquotes("quotes[?(@.id==\"${ids}\")]")
        if (response.isSuccessful && response.body() != null){
            _quotes.emit(response.body()!!)

        }
    }
}