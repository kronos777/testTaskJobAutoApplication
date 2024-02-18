package com.example.workautoapplication.data

import android.app.Application
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [AutoItemDbModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun AutoListDao(): AutoListDao

    companion object {

        private var INSTANCE: AppDatabase? = null
        private var LOCK = Any()
        const val DB_NAME = "auto_db"

        fun getInstance(application: Application): AppDatabase {
            INSTANCE?.let { return it }
            synchronized(LOCK) {
                INSTANCE?.let { return it }
                val db = Room.databaseBuilder(
                    application,
                    AppDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()
                INSTANCE = db
                return db
            }
        }


    }

}