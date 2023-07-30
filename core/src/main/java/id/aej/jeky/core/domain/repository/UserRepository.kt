package id.aej.jeky.core.domain.repository

import id.aej.jeky.core.data.source.Resource
import kotlinx.coroutines.flow.Flow

/**
 * Created by dino.priyano on 30/07/23.
 */
interface UserRepository {
  suspend fun isUserLoggedIn(): Flow<Resource<Boolean>>
  suspend fun storeEmail(email: String)
  suspend fun logout()
}