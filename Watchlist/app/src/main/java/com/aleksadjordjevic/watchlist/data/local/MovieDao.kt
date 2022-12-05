package com.aleksadjordjevic.watchlist.data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aleksadjordjevic.watchlist.data.local.entity.TrackedMovieEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrackedMovie(trackedMovieEntity: TrackedMovieEntity)

    @Delete
    suspend fun deleteTrackedMovie(trackedMovieEntity: TrackedMovieEntity)

    @Query("SELECT * FROM trackedmovieentity")
    fun getAllTrackedMovies(): Flow<List<TrackedMovieEntity>>
}