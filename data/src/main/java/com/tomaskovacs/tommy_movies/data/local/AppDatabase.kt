package com.tomaskovacs.tommy_movies.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tomaskovacs.tommy_movies.data.local.model.MovieLocal

@Database(entities = [MovieLocal::class], version = 2)
abstract class AppDatabase : RoomDatabase() {
    abstract fun movieDao(): MovieDao

    companion object {
        fun buildAppDatabase(context: Context) = Room.databaseBuilder(
            context, AppDatabase::class.java, DATABASE_NAME
        ).fallbackToDestructiveMigration().build()
    }
}
