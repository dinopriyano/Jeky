package id.aej.jeky.core.domain

import id.aej.jeky.core.domain.repository.AuthRepository
import id.aej.jeky.core.domain.repository.PlacesRepository
import id.aej.jeky.core.domain.repository.UserRepository
import id.aej.jeky.core.domain.usecase.AuthUseCase
import id.aej.jeky.core.domain.usecase.PlacesUseCase
import id.aej.jeky.core.domain.usecase.UserUseCase

/**
 * Created by dino.priyano on 18/06/23.
 */
interface JekyContainer {
  val authRepository: AuthRepository
  val userRepository: UserRepository
  val placesRepository: PlacesRepository
  val authUseCase: AuthUseCase
  val userUseCase: UserUseCase
  val placesUseCase: PlacesUseCase
}