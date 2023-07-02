package id.aej.jeky

import android.app.Application
import id.aej.jeky.core.data.JekyContainerImpl
import id.aej.jeky.core.domain.JekyContainer

/**
 * Created by dino.priyano on 18/06/23.
 */

class JekyApplication: Application() {

  lateinit var jekyContainer: JekyContainer

  override fun onCreate() {
    super.onCreate()
    jekyContainer = JekyContainerImpl(context = applicationContext)
  }
}