package com.example.tennisapp.data.database.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.tennisapp.data.database.models.TeamItemDbModel

@Database(entities = [TeamItemDbModel::class], version = 1, exportSchema = false)
abstract class TeamDatabase : RoomDatabase() {
    companion object {
        private var db: TeamDatabase? = null
        private const val DB_NAME = "team.db"
        private val LOCK = Any()

        fun getInstance(context: Context): TeamDatabase {
            synchronized(LOCK) {
                db?.let { return it }
                val instance = Room.databaseBuilder(
                    context,
                    TeamDatabase::class.java,
                    DB_NAME
                )
                    .fallbackToDestructiveMigration()
                    .build()

                db = instance
                return instance
            }
        }
    }

    abstract fun teamDao(): TeamDao
}