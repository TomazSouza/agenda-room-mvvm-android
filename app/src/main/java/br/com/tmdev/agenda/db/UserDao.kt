package br.com.tmdev.agenda.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserDao {

    @Query("SELECT * FROM user_table ORDER BY name ASC")
    fun getAlphabetizedUsers(): LiveData<List<UserEntity>>?

    @Insert
    suspend fun insertUser(userEntity: UserEntity)

    @Query("DELETE FROM user_table")
    suspend fun deleteAll()

    @Query("SELECT * FROM user_table WHERE id = :id")
    fun  getUserById(id: Int): UserEntity?

}