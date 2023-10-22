package id.aej.jeky.presentation.screen.home

import id.aej.jeky.core.data.source.remote.dto.response.RoutesResponse

/**
 * Created by dino.priyano on 20/08/23.
 */
sealed class HomeUiState {

  class Success(val data: RoutesResponse): HomeUiState()

  class Error(val message: String): HomeUiState()

  object Idle: HomeUiState()

  object Loading: HomeUiState()

}
