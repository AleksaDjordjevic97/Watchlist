package com.aleksadjordjevic.watchlist.presentation.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aleksadjordjevic.watchlist.R
import com.aleksadjordjevic.watchlist.presentation.home.components.AddBtn
import com.aleksadjordjevic.watchlist.presentation.home.components.TrackedMovieCard
import com.aleksadjordjevic.watchlist.presentation.ui.theme.fabBackgroundColor
import com.aleksadjordjevic.watchlist.presentation.ui.theme.fabIconColor

@Composable
fun HomeScreen(
    navigateToSearch: () -> Unit,
    viewModel: HomeViewModel = hiltViewModel()
){
    val state = viewModel.state

    Box(
        modifier = Modifier.fillMaxSize()
    ){
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Home Screen Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            Text(
                text = "My Watchlist",
                style = MaterialTheme.typography.titleLarge
            )
            Spacer(modifier = Modifier.height(50.dp))
            LazyVerticalGrid(
                columns = GridCells.Fixed(3),
                modifier = Modifier
                    .fillMaxSize()
            ){
                items(state.trackedMovies){ trackedMovie ->
                    TrackedMovieCard(
                        imageUrl = trackedMovie.imageUrl,
                        title = trackedMovie.title,
                        year = trackedMovie.year)

                }
            }
        }
        AddBtn(
            iconColor = fabIconColor,
            backgroundColor = fabBackgroundColor,
            onClick = { navigateToSearch() },
            modifier = Modifier
                .size(90.dp)
                .padding(all = 16.dp)
                .align(alignment = Alignment.BottomEnd)
        )
    }


}