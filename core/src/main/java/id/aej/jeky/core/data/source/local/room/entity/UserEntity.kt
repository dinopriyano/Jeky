package id.aej.jeky.core.data.source.local.room.entity

import android.service.autofill.UserData
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import id.aej.jeky.core.domain.model.User

/**
 * Created by dino.priyano on 18/06/23.
 */

@Entity(
  tableName = "user"
)
data class UserEntity(
  @ColumnInfo(name = "email")
  @PrimaryKey
  val email: String,

  @ColumnInfo(name = "password")
  val password: String,

  @ColumnInfo(name = "full_name")
  val name: String,

  @ColumnInfo(name = "phone_number")
  val phoneNumber: String
)

fun UserEntity.toDomain() = User (
  this.email,
  this.password,
  this.name,
  this.phoneNumber
)
