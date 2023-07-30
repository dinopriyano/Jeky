package id.aej.jeky.presentation.screen.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.aej.jeky.JekyApplication
import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.domain.usecase.AuthUseCase
import id.aej.jeky.core.domain.usecase.UserUseCase
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

/**
 * Created by dino.priyano on 02/07/23.
 */
class LoginViewModel constructor(
  private val useCase: AuthUseCase,
  private val userUseCase: UserUseCase
): ViewModel() {

  private val _loginUiState = MutableSharedFlow<LoginUiState>()
  val loginUiState get() = _loginUiState.asSharedFlow()

  companion object {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
      initializer {
        val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as JekyApplication)
        LoginViewModel(
          application.jekyContainer.authUseCase,
          application.jekyContainer.userUseCase
        )
      }
    }
  }

  fun login(email: String, password: String) {
    viewModelScope.launch {
      _loginUiState.emit(LoginUiState.Loading)
      useCase.login(email, password)
        .collect {
          when (it) {
            is Resource.Success -> {
              _loginUiState.emit(LoginUiState.Success(it.data))
            }
            is Resource.Error -> {
              _loginUiState.emit(LoginUiState.Error(it.message))
            }
            else -> Unit
          }
        }
    }
  }

  fun storeEmail(email: String) {
    viewModelScope.launch {
      userUseCase.storeEmail(email)
    }
  }
}