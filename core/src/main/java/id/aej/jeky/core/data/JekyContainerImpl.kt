package id.aej.jeky.core.data

import android.content.Context
import id.aej.jeky.core.data.repository.AuthRepositoryImpl
import id.aej.jeky.core.data.source.local.room.JekyDatabase
import id.aej.jeky.core.domain.JekyContainer
import id.aej.jeky.core.domain.repository.AuthRepository

/**
 * Created by dino.priyano on 18/06/23.
 */
class JekyContainerImpl constructor(
  private val context: Context
) : JekyContainer {

  private val jekyDatabase: JekyDatabase by lazy {
    JekyDatabase.getInstance(context)
  }

  override val authRepository: AuthRepository
    get() = AuthRepositoryImpl(jekyDatabase.userDao())
}