package id.aej.jeky.core.data.interactors

import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.domain.model.User
import id.aej.jeky.core.domain.repository.AuthRepository
import id.aej.jeky.core.domain.usecase.AuthUseCase
import kotlinx.coroutines.flow.Flow

/**
 * Created by dino.priyano on 30/07/23.
 */
class AuthInteractor constructor(
  private val authRepository: AuthRepository
): AuthUseCase {
  override suspend fun login(email: String, password: String): Flow<Resource<User>> {
    return authRepository.login(email, password)
  }

  override suspend fun register(user: User): Flow<Resource<User>> {
    return authRepository.register(user)
  }
}