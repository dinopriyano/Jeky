package id.aej.jeky.presentation.screen.home

import id.aej.jeky.core.data.source.remote.dto.response.GetPlacesRoutesResponse
import id.aej.jeky.core.domain.model.Places
import id.aej.jeky.presentation.screen.login.LoginUiState

/**
 * Created by dino.priyano on 20/08/23.
 */
sealed class HomeUiState {

  class Success(val data: GetPlacesRoutesResponse): HomeUiState()

  class Error(val message: String): HomeUiState()

  object Idle: HomeUiState()

  object Loading: HomeUiState()

}
