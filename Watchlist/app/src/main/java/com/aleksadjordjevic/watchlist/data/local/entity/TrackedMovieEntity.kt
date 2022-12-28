package com.aleksadjordjevic.watchlist.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TrackedMovieEntity(
    @PrimaryKey(autoGenerate = false)
    val imdbId:String,
    val title:String,
    val year:Int,
    val imageUrl:String,
)
