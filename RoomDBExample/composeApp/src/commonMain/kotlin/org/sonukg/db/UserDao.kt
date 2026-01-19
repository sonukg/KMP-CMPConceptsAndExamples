package org.sonukg.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(item: User)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(items: List<User>)

    @Query("SELECT * FROM User")
    fun getAllAsFlow(): Flow<List<User>>


    @Query("SELECT * FROM User")
    suspend fun getAll(): List<User>

    @Query("SELECT count(*) FROM User")
    suspend fun count(): Int
}