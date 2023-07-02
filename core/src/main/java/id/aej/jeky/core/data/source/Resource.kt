package id.aej.jeky.core.data.source

/**
 * Created by dino.priyano on 02/07/23.
 */
sealed class Resource<out T> {
  data class Success<T>(val data: T): Resource<T>()
  data class Error(val errorCode: Int, val message: String): Resource<Nothing>()
  object Loading: Resource<Nothing>()
  object Empty: Resource<Nothing>()
}
