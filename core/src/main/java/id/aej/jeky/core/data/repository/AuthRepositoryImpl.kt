package id.aej.jeky.core.data.repository

import id.aej.jeky.core.data.source.local.room.dao.UserDao
import id.aej.jeky.core.data.source.local.room.entity.toDomain
import id.aej.jeky.core.domain.model.User
import id.aej.jeky.core.domain.model.toEntity
import id.aej.jeky.core.domain.repository.AuthRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map

/**
 * Created by dino.priyano on 18/06/23.
 */
class AuthRepositoryImpl constructor(
  private val dao: UserDao
): AuthRepository {
  override suspend fun login(email: String, password: String): Flow<List<User>> {
    return flow {
      emitAll(
        dao.getUserByEmailAndPassword(email, password).map {
          it.map { user ->
            user.toDomain()
          }
        }
      )
    }
  }

  override suspend fun register(user: User): Flow<User> {
    return flow {
      dao.insertUser(user.toEntity())
      emit(user)
    }
  }
}