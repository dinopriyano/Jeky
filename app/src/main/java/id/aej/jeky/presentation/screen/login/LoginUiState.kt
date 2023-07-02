package id.aej.jeky.presentation.screen.login

import id.aej.jeky.core.domain.model.User

/**
 * Created by dino.priyano on 02/07/23.
 */
sealed class LoginUiState {

  class Success(val data: User): LoginUiState()

  class Error(val message: String): LoginUiState()

  object Idle: LoginUiState()

  object Loading: LoginUiState()

}
