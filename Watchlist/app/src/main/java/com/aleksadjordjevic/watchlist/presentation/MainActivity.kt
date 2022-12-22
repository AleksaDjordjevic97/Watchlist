package com.aleksadjordjevic.watchlist.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.presentation.home.HomeScreen
import com.aleksadjordjevic.watchlist.presentation.navigation.Route
import com.aleksadjordjevic.watchlist.presentation.search.SearchScreen
import com.aleksadjordjevic.watchlist.presentation.ui.theme.WatchlistTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WatchlistTheme {

                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = Route.HOME_SCREEN
                ){
                    composable(Route.HOME_SCREEN){
                        HomeScreen({
                            navController.navigate(Route.SEARCH)
                        })
                    }
                    composable(route = Route.SEARCH) {
                        SearchScreen()
                    }
                }
            }
        }
    }
}