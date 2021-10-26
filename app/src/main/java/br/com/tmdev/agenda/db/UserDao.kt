package br.com.tmdev.agenda.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

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

    @Query("UPDATE user_table SET name = :name, email = :email, contact = :contact WHERE id = :id")
    suspend fun updated(id: Int, name: String, email: String, contact: String)

    @Query("DELETE FROM user_table WHERE id = :id")
    suspend fun deleteById(id: Int)

}