package com.example.basicapp.Screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.basicapp.Models.Quote
import com.example.basicapp.ViewModel.detailViewModel

@Composable
fun DetailScreen(modifier: Modifier = Modifier) {
    val detailviewmodel : detailViewModel = hiltViewModel()
    val quotes = detailviewmodel.quotes.collectAsState()
   LazyColumn (content = {
       items(quotes.value){
           quoteListItem(quote = it)
       }
   },
       modifier = Modifier.padding(0.dp,40.dp,0.dp,0.dp)
           .background(Color.White))
    
}

@Composable
fun quoteListItem(modifier: Modifier = Modifier,quote:Quote) {
    Card( modifier = Modifier
        .background(Color.White)
        .fillMaxWidth()
        .padding(16.dp),
        border = BorderStroke(2.dp, Color(0xFFCCCCCC)),
        content = {
            Text(text = quote.quote,
                color = Color.Black,
                modifier =Modifier
                    .background(Color.White)
                    .padding(5.dp)
                    ,
                style = MaterialTheme.typography.bodyMedium)
        }
        )


    
}