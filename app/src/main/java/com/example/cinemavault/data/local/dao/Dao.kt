package com.example.cinemavault.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.cinemavault.data.local.entity.TrendingMoviesEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrendingMoviesDao {

    @Query("SELECT * FROM movies_items_trending")
     fun getAll():Flow< List<TrendingMoviesEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(movie: List<TrendingMoviesEntity>)

    @Delete
    suspend fun deleteMovies(moviesModel: TrendingMoviesEntity)
}