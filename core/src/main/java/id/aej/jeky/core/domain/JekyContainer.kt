package id.aej.jeky.core.domain

import id.aej.jeky.core.domain.repository.AuthRepository

/**
 * Created by dino.priyano on 18/06/23.
 */
interface JekyContainer {
  val authRepository: AuthRepository
}