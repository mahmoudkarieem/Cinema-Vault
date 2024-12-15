package com.example.cinemavault.data.local.data_base

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.cinemavault.data.local.converters.ConvertersGeneralIds
import com.example.cinemavault.data.local.dao.TrendingMoviesDao
import com.example.cinemavault.data.local.entity.TrendingMoviesEntity
import com.example.cinemavault.domain.Model.MovieTrendingItemModel
import com.example.cinemavault.domain.Model.TrendingMoviesModel

@Database(
    entities = [ TrendingMoviesEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(ConvertersGeneralIds::class)
abstract class TrendingMoviesDataBase : RoomDatabase() {

    abstract fun movieDao(): TrendingMoviesDao


}