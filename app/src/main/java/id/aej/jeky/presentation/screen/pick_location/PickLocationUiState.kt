package id.aej.jeky.presentation.screen.pick_location

import id.aej.jeky.core.domain.model.Places
import id.aej.jeky.presentation.screen.login.LoginUiState

/**
 * Created by dino.priyano on 20/08/23.
 */
sealed class PickLocationUiState {

  class Success(val data: Places): PickLocationUiState()

  class Error(val message: String): PickLocationUiState()

  object Idle: PickLocationUiState()

  object Loading: PickLocationUiState()

}
