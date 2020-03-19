package br.com.tmdev.agenda.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class UserRoomDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserDao

    companion object {
        @Volatile
        private var INSTANCE: UserRoomDatabase? = null

        fun getDatabase(context: Context?): UserRoomDatabase? {
            if (INSTANCE == null) {
                synchronized(this) {
                    INSTANCE = Room.databaseBuilder(
                        context?.applicationContext!!,
                        UserRoomDatabase::class.java,
                        "agenda_db"
                    ).build()
                }
            }
            return INSTANCE
        }
    }

}