package com.aleksadjordjevic.watchlist.presentation.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.aleksadjordjevic.watchlist.R
import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TrackableMovieItem(
    movie: MovieData,
    onTrack: () -> Unit,
    isTracked: Boolean,
    modifier: Modifier = Modifier
) {
    val trackedState = remember { mutableStateOf(isTracked) }

    Row(
        modifier = modifier
            .clip(RoundedCornerShape(10.dp))
            .padding(5.dp)
            .shadow(
                elevation = 1.dp,
                shape = RoundedCornerShape(5.dp)
            )
            .background(MaterialTheme.colorScheme.surface)
    ) {
        GlideImage(
            model= movie.imageUrl,
            contentDescription = "Trackable_${movie.title}",
            modifier = Modifier
                .fillMaxHeight()
                .padding(5.dp)
                .weight(1f)
        )
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(2f)
        ) {
            Text(
                text = "${movie.title} (${movie.year})",
                style = MaterialTheme.typography.labelMedium,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
        Box(
            modifier = Modifier
                .fillMaxHeight()
                .weight(1f)
        ){
            IconButton(
                onClick = {
                            onTrack()
                            trackedState.value = !trackedState.value
                          },
                    modifier = Modifier
                        .align(Alignment.Center)
                    ) {
                    Image(
                        painter = if(trackedState.value)
                            painterResource(id = R.drawable.done_track_movie_btn)
                        else
                            painterResource(id = R.drawable.add_track_movie_btn),
                        contentDescription = "Trackable_${movie.title}")
                }
        }
    }
}