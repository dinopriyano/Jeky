package id.aej.jeky.presentation.screen.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.aej.jeky.JekyApplication
import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.domain.model.User
import id.aej.jeky.core.domain.repository.AuthRepository
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * Created by dino.priyano on 02/07/23.
 */
class RegisterViewModel constructor(
  private val repository: AuthRepository
): ViewModel() {

  private val _registerUiState = MutableSharedFlow<RegisterUiState>()
  val registerUiState get() = _registerUiState.asSharedFlow()

  companion object {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
      initializer {
        val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as JekyApplication)
        RegisterViewModel(application.jekyContainer.authRepository)
      }
    }
  }

  fun register(user: User) {
    viewModelScope.launch {
      _registerUiState.emit(RegisterUiState.Loading)
      repository.register(user)
        .collect {
          when (it) {
            is Resource.Success -> {
              _registerUiState.emit(RegisterUiState.Success(it.data))
            }
            is Resource.Error -> {
              _registerUiState.emit(RegisterUiState.Error(it.message))
            }
            else -> Unit
          }
        }
    }
  }
}