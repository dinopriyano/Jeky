package id.aej.jeky.presentation.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.aej.jeky.JekyApplication
import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.domain.usecase.PlacesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

/**
 * Created by dino.priyano on 18/09/23.
 */
class HomeViewModel constructor(
  private val placesUseCase: PlacesUseCase
): ViewModel() {

  private val _uiState = MutableStateFlow<HomeUiState>(HomeUiState.Idle)
  val uiState: StateFlow<HomeUiState> get() = _uiState.asStateFlow()

  companion object {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
      initializer {
        val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as JekyApplication)
        HomeViewModel(
          application.jekyContainer.placesUseCase
        )
      }
    }
  }

  fun getPlaceRoutes(origin: Pair<Double, Double>, destination: Pair<Double, Double>) {
    viewModelScope.launch {
      _uiState.emit(HomeUiState.Loading)
      placesUseCase.getPlaceRoutes("${origin.first},${origin.second}", "${destination.first},${destination.second}")
        .collect {
          when(it) {
            is Resource.Success -> {
              _uiState.emit(HomeUiState.Success(it.data))
            }
            is Resource.Error -> {
              _uiState.emit(HomeUiState.Error(it.message))
            }
            else -> Unit
          }
        }
    }
  }

}