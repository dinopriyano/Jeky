package id.aej.jeky.core.data.source.local.room.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import id.aej.jeky.core.data.source.local.room.entity.UserEntity
import kotlinx.coroutines.flow.Flow

/**
 * Created by dino.priyano on 18/06/23.
 */

@Dao
interface UserDao {

  @Insert
  suspend fun insertUser(userEntity: UserEntity)

  @Query("SELECT * FROM user WHERE email = :email AND password = :password")
  fun getUserByEmailAndPassword(email: String, password: String): Flow<List<UserEntity>>

}