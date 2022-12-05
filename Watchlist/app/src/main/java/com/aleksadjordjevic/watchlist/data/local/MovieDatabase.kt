package com.aleksadjordjevic.watchlist.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aleksadjordjevic.watchlist.data.local.entity.TrackedMovieEntity

@Database(entities = [TrackedMovieEntity::class], version = 1)
abstract class MovieDatabase:RoomDatabase() {
    abstract val dao:MovieDao
}