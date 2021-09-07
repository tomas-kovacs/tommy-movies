package com.tomaskovacs.tommy_movies.di

import com.tomaskovacs.tommy_movies.data.local.MoviesLocalDataSource
import com.tomaskovacs.tommy_movies.data.local.MoviesLocalDataSourceImpl
import com.tomaskovacs.tommy_movies.data.remote.MoviesApi
import com.tomaskovacs.tommy_movies.data.remote.MoviesRemoteDataSource
import com.tomaskovacs.tommy_movies.data.remote.MoviesRemoteDataSourceImpl
import com.tomaskovacs.tommy_movies.data.repository.MoviesRepositoryImpl
import com.tomaskovacs.tommy_movies.domain.repository.MoviesRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@InstallIn(SingletonComponent::class)
@Module
class DataModule {

    @Provides
    fun providesMoviesLocalDataSource(): MoviesLocalDataSource {
        return MoviesLocalDataSourceImpl()
    }

    @Provides
    fun providesOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor()).build()
    }

    @Provides
    fun providesRetrofitInstance(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    fun providesMoviesApi(retrofit: Retrofit): MoviesApi {
        return retrofit.create(MoviesApi::class.java)
    }

    @Provides
    fun providesMoviesRemoteDataSource(api: MoviesApi): MoviesRemoteDataSource {
        return MoviesRemoteDataSourceImpl(api)
    }

    @Provides
    fun providesMoviesRepository(
        remoteDataSource: MoviesRemoteDataSource,
        localDataSource: MoviesLocalDataSource
    ): MoviesRepository {
        return MoviesRepositoryImpl(remoteDataSource, localDataSource)
    }
}
