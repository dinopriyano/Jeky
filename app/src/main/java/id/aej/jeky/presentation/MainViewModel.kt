package id.aej.jeky.presentation

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import id.aej.jeky.JekyApplication
import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.domain.usecase.UserUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

/**
 * Created by dino.priyano on 30/07/23.
 */
class MainViewModel constructor(
  private val userUseCase: UserUseCase
): ViewModel() {

  private val _isUserLoggedIn = MutableStateFlow<Boolean?>(null)
  val isUserLoggedIn: StateFlow<Boolean?> get() = _isUserLoggedIn

  private val _isSplashFinished = MutableStateFlow(false)
  val isSplashFinished: StateFlow<Boolean> get() = _isSplashFinished

  companion object {
    val Factory: ViewModelProvider.Factory = viewModelFactory {
      initializer {
        val application = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as JekyApplication)
        MainViewModel(application.jekyContainer.userUseCase)
      }
    }
  }

  init {
    getIsUserLoggedIn()
  }

  private fun getIsUserLoggedIn() {
    viewModelScope.launch {
      when (val result = userUseCase.isUserLoggedIn().first()) {
        is Resource.Success -> {
          _isUserLoggedIn.update {
            result.data
          }
          _isSplashFinished.update {
            true
          }
        }
        is Resource.Error -> {
          Log.d("Get Is User Logged In", "Error: ${result.message}")
        }
        else -> Unit
      }
    }
  }

}