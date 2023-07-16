package id.aej.jeky.core.data.repository

import android.database.sqlite.SQLiteConstraintException
import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.data.source.local.room.dao.UserDao
import id.aej.jeky.core.data.source.local.room.entity.toDomain
import id.aej.jeky.core.domain.model.User
import id.aej.jeky.core.domain.model.toEntity
import id.aej.jeky.core.domain.repository.AuthRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

/**
 * Created by dino.priyano on 18/06/23.
 */
class AuthRepositoryImpl constructor(
  private val dao: UserDao
): AuthRepository {
  override suspend fun login(email: String, password: String): Flow<Resource<User>> {
    return flow<Resource<User>> {
      val users = dao.getUserByEmailAndPassword(email, password).first()
      if (users.isNotEmpty()) {
        emit(Resource.Success(users.first().toDomain()))
      } else {
        emit(Resource.Error(-1, "Your credential not valid, please check your email and password!"))
      }
    }.catch { e ->
      emit(Resource.Error(-1, e.message ?: "Something wrong."))
    }.flowOn(Dispatchers.IO)
  }

  override suspend fun register(user: User): Flow<Resource<User>> {
    return flow<Resource<User>> {
      dao.insertUser(user.toEntity())
      emit(Resource.Success(user))
    }.catch { e ->
      when (e) {
        is SQLiteConstraintException -> {
          emit(Resource.Error(-1, "Email already registered in apps, use another email!"))
        }
        else -> {
          emit(Resource.Error(-1, e.message ?: "Something wrong"))
        }
      }
    }.flowOn(Dispatchers.IO)
  }
}