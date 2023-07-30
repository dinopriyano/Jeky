package id.aej.jeky.core.data

import android.content.Context
import id.aej.jeky.core.data.interactors.AuthInteractor
import id.aej.jeky.core.data.interactors.UserInteractor
import id.aej.jeky.core.data.repository.AuthRepositoryImpl
import id.aej.jeky.core.data.repository.UserRepositoryImpl
import id.aej.jeky.core.data.source.local.datastore.JekyDataStore
import id.aej.jeky.core.data.source.local.room.JekyDatabase
import id.aej.jeky.core.domain.JekyContainer
import id.aej.jeky.core.domain.repository.AuthRepository
import id.aej.jeky.core.domain.repository.UserRepository
import id.aej.jeky.core.domain.usecase.AuthUseCase
import id.aej.jeky.core.domain.usecase.UserUseCase

/**
 * Created by dino.priyano on 18/06/23.
 */
class JekyContainerImpl constructor(
  private val context: Context
) : JekyContainer {

  private val jekyDatabase: JekyDatabase by lazy {
    JekyDatabase.getInstance(context)
  }

  private val jekyDataStore: JekyDataStore by lazy {
    JekyDataStore(context)
  }

  override val authRepository: AuthRepository
    get() = AuthRepositoryImpl(jekyDatabase.userDao())

  override val userRepository: UserRepository
    get() = UserRepositoryImpl(jekyDataStore)

  override val authUseCase: AuthUseCase
    get() = AuthInteractor(authRepository)

  override val userUseCase: UserUseCase
    get() = UserInteractor(userRepository)
}