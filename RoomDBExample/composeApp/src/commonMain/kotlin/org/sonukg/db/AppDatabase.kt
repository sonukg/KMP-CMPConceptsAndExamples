package org.sonukg.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.RoomDatabaseConstructor

@Database(entities = [User::class], version = 1)
@Con
abstract class AppDatabase : RoomDatabase(){
    abstract fun getDao() : UserDao
}

expect object AppDatabaseConstructor : RoomDatabaseConstructor<AppDatabase> {
    override fun initialize(): AppDatabase

}