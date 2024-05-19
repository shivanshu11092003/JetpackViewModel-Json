package com.example.basicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.basicapp.Api.TweetsyApi
import com.example.basicapp.Screens.DetailScreen
import com.example.basicapp.Screens.categoryScreen
import com.example.basicapp.ui.theme.BasicAppTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    @Inject
    lateinit var tweetsyApi: TweetsyApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            BasicAppTheme {
                App()
            }
        }
    }
}

@Composable
fun App(modifier: Modifier = Modifier) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "category"){
        composable(route = "category"){
            categoryScreen {
                //kotlin me agar last parameter agar lambda hai to ham use bahhar nikal skte hai
                navController.navigate("detail/${it}")
            }
        }
        composable(route = "detail/{category}",
            arguments = listOf(
                navArgument("category"){
                    type = NavType.IntType
                }
            )
        ){
            DetailScreen()
        }

    }

}

