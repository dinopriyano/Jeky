package id.aej.jeky.core.domain.repository

import id.aej.jeky.core.domain.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Created by dino.priyano on 18/06/23.
 */
interface AuthRepository {
  suspend fun login(email: String, password: String): Flow<List<User>>
  suspend fun register(user: User): Flow<User>
}