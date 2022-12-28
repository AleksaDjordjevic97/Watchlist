package com.aleksadjordjevic.watchlist.presentation.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.aleksadjordjevic.watchlist.R
import com.aleksadjordjevic.watchlist.presentation.search.components.SearchTextField
import com.aleksadjordjevic.watchlist.presentation.search.components.TrackableMovieItem

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun SearchScreen(
    viewModel: SearchViewModel = hiltViewModel()
){
    val state = viewModel.state
    val keyboardController = LocalSoftwareKeyboardController.current

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.background),
            contentDescription = "Search Screen Background",
            contentScale = ContentScale.FillBounds,
            modifier = Modifier
                .fillMaxSize()
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Spacer(modifier = Modifier.height(30.dp))
            SearchTextField(
                text = state.query,
                onValueChange = { viewModel.onEvent(SearchEvent.onQueryChange(it)) },
                onSearch = {
                    keyboardController?.hide()
                    viewModel.onEvent(SearchEvent.onSearch) },
                shouldShowHint = state.isHintVisible,
                onFocusChanged = { viewModel.onEvent(SearchEvent.OnSearchFocusChange(it.isFocused)) }
            )
            Spacer(modifier = Modifier.height(30.dp))
            LazyColumn(
                modifier = Modifier.fillMaxSize()
            ) {
                items(state.trackableMovies) { movie ->
                    TrackableMovieItem(
                        movie = movie,
                        onTrack = { viewModel.onEvent(SearchEvent.OnTrackMovie(movie)) },
                        isTracked = viewModel.isMovieTracked(movie),
                        modifier = Modifier
                            .height(100.dp)
                    )
                }
            }
        }
    }
}