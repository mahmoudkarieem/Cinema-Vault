package com.example.cinemavault.di

import android.app.Application
import androidx.room.Room
import com.example.cinemavault.data.local.dao.TrendingMoviesDao
import com.example.cinemavault.data.local.data_base.TrendingMoviesDataBase
import com.example.cinemavault.data.mapper.CategoriesMapper
import com.example.cinemavault.data.mapper.DetailsMapper
import com.example.cinemavault.data.mapper.MoviesMapper
import com.example.cinemavault.data.mapper.TrendingMapper
import com.example.cinemavault.data.remote.api.MoviesApi
import com.example.cinemavault.data.repository.CategoriesRepositoryImpl
import com.example.cinemavault.data.repository.DetailsRepositoryImpl
import com.example.cinemavault.data.repository.MoviesRepositoryImpl
import com.example.cinemavault.data.repository.TrendingRepositoryImpl
import com.example.cinemavault.domain.repository.CategoriesRepository
import com.example.cinemavault.domain.repository.DetailsRepository
import com.example.cinemavault.domain.repository.MoviesRepository
import com.example.cinemavault.domain.repository.TrendingMoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun provideMoviesApi(retrofit: Retrofit): MoviesApi = retrofit.create(MoviesApi::class.java)


    @Singleton
    @Provides
    fun provideMoviesRepository(
        moviesMapper: MoviesMapper,
        api: MoviesApi
    ): MoviesRepository = MoviesRepositoryImpl(
        mapper = moviesMapper,
        api = api
    )

    @Singleton
    @Provides
    fun provideCategoriesRepository(
        categoriesMapper: CategoriesMapper,
        api: MoviesApi
    ): CategoriesRepository = CategoriesRepositoryImpl(
        mapper = categoriesMapper,
        api = api
    )
    @Singleton
    @Provides
    fun provideTrendingRepository(
        api: MoviesApi,
        trendingMapper: TrendingMapper,
        dao: TrendingMoviesDao

    ): TrendingMoviesRepository = TrendingRepositoryImpl(
        trendingApi = api,
        mapper = trendingMapper,
        dao = dao
    )


    @Singleton
    @Provides
    fun provideDetailsRepository(
        api: MoviesApi,
        mapper: DetailsMapper
    ): DetailsRepository = DetailsRepositoryImpl(
        mapper = mapper,
        api = api
    )

    @Singleton
    @Provides
    fun provideRoomDataBase(
        application: Application
    ): TrendingMoviesDataBase {
        return Room.databaseBuilder(
            context = application,
            klass = TrendingMoviesDataBase::class.java,
            name = "dp_name"
        )
            .build()
    }


    @Singleton
    @Provides
    fun provideDao(
        roomDataBase: TrendingMoviesDataBase
    ): TrendingMoviesDao {
        return roomDataBase.movieDao()
    }
}