package id.aej.jeky.core.data.interactors

import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.domain.repository.UserRepository
import id.aej.jeky.core.domain.usecase.UserUseCase
import kotlinx.coroutines.flow.Flow

/**
 * Created by dino.priyano on 30/07/23.
 */
class UserInteractor constructor(
  private val userRepository: UserRepository
): UserUseCase {
  override suspend fun isUserLoggedIn(): Flow<Resource<Boolean>> {
    return userRepository.isUserLoggedIn()
  }

  override suspend fun storeEmail(email: String) {
    userRepository.storeEmail(email)
  }

  override suspend fun logout() {
    userRepository.logout()
  }
}