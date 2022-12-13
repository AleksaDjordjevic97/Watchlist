package com.aleksadjordjevic.watchlist.presentation.search.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.net.toUri
import coil.compose.AsyncImage
import coil.compose.rememberAsyncImagePainter
import com.aleksadjordjevic.watchlist.R
import com.aleksadjordjevic.watchlist.domain.movie.MovieData
import com.aleksadjordjevic.watchlist.presentation.ui.theme.trackableMovieLabelColor
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun TrackableMovieItem(
    movie: MovieData,
    onTrack: () -> Unit,
    modifier: Modifier = Modifier
) {
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
                onClick = onTrack,
                modifier = Modifier
                    .align(Alignment.Center)
            ) {
                Image(
                    painter = painterResource(id = R.drawable.add_track_movie_btn),
                    contentDescription = "Trackable_${movie.title}")
            }
        }


    }
}

@Preview
@Composable
fun previewTrackableMovieItem(){
    TrackableMovieItem(
        movie =     MovieData(
            id = "sfafas",
            title = "Avengers",
            year = 2012,
            imageUrl = "https://m.media-amazon.com/images/M/MV5BNDYxNjQyMjAtNTdiOS00NGYwLWFmNTAtNThmYjU5ZGI2YTI1XkEyXkFqcGdeQXVyMTMxODk2OTU@._V1_.jpg"
        ),
        onTrack = {}
    )
}