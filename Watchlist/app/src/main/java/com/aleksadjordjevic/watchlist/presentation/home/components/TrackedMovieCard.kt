package com.aleksadjordjevic.watchlist.presentation.home.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.aleksadjordjevic.watchlist.R

@Composable
fun TrackedMovieCard(
    imageUrl: String,
    title: String,
    year: Int,
    onRemoveBtnClick: () -> Unit,
    modifier: Modifier = Modifier
){
    Box(
        modifier = modifier
    ) {
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
            ) {
                Image(
                    painter = rememberAsyncImagePainter(imageUrl),
                    contentDescription = "Tracked_$title",
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(150.dp)
                        .padding(0.dp, 10.dp)
                        .clip(RoundedCornerShape(20.dp))
                )
                IconButton(
                    onClick = onRemoveBtnClick,
                    modifier = Modifier
                        .size(30.dp)
                        .align(Alignment.TopEnd)
                ) {
                   Image(
                       painter = painterResource(id = R.drawable.remove_tracked_movie_btn),
                       contentDescription = "Remove Tracked Movie"
                   )
                }
            }
            Spacer(modifier = Modifier.height(10.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = title,
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center
                )
                Text(
                    text = "($year)",
                    style = MaterialTheme.typography.labelSmall,
                    textAlign = TextAlign.Center
                )
            }
            Spacer(modifier = Modifier.height(25.dp))
        }
    }
}