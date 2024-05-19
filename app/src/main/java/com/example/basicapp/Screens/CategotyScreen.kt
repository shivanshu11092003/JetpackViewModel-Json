package com.example.basicapp.Screens

import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.paint
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.motionEventSpy
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.basicapp.R
import com.example.basicapp.ViewModel.CategoryViewModel
import com.example.basicapp.ViewModel.detailViewModel

@Composable
fun categoryScreen(onClick:(category: Int)-> Unit) {
    val categoryviewmodel : CategoryViewModel = hiltViewModel()

    val Categories = categoryviewmodel.categories.collectAsState()


    LazyVerticalGrid(columns = GridCells.Fixed(2),
        contentPadding = PaddingValues(8.dp),
        verticalArrangement = Arrangement.SpaceAround,
        modifier = Modifier
            .padding(0.dp,60.dp,0.dp,0.dp)
    ){
        items(Categories.value.distinct()){
            categoryItem(category = it,onClick)

        }
    }
    
}

@Composable
fun categoryItem(category : Int,onClick:(category: Int)-> Unit) {
     Box (modifier = Modifier

         .clickable {
             onClick(category)
         }

         .padding(8.dp)
         .size(160.dp)
         .clip(RoundedCornerShape(8.dp))
         .border(1.dp, Color(0xFFEEEEEE))
         .paint(painter = painterResource(id = R.drawable.polygon_scatter_haikei)
         , alignment = Alignment.TopCenter),
         contentAlignment = Alignment.Center

     ){
         Text(
             text = category.toString(),
             fontSize = 24.sp,
             color = Color.Black
                 , modifier = Modifier.padding(0.dp,70.dp,0.dp,0.dp),
             style = MaterialTheme.typography.bodySmall,
             textAlign = TextAlign.End
         )


     }
    
}