package br.com.tmdev.agenda.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_table")
open class UserEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "name")
    var name: String = ""

    @ColumnInfo(name = "contact")
    var contact: String = ""

    @ColumnInfo(name = "email")
    var email: String = ""

    override fun toString(): String {
        return "UserEntity(id=$id, name='$name', contact='$contact', email='$email')"
    }

}