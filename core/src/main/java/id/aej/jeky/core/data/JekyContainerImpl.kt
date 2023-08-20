package id.aej.jeky.core.data

import android.content.Context
import id.aej.jeky.core.data.interactors.AuthInteractor
import id.aej.jeky.core.data.interactors.PlacesInteractor
import id.aej.jeky.core.data.interactors.UserInteractor
import id.aej.jeky.core.data.repository.AuthRepositoryImpl
import id.aej.jeky.core.data.repository.PlacesRepositoryImpl
import id.aej.jeky.core.data.repository.UserRepositoryImpl
import id.aej.jeky.core.data.source.local.datastore.JekyDataStore
import id.aej.jeky.core.data.source.local.room.JekyDatabase
import id.aej.jeky.core.data.source.remote.network.JekyService
import id.aej.jeky.core.domain.JekyContainer
import id.aej.jeky.core.domain.repository.AuthRepository
import id.aej.jeky.core.domain.repository.PlacesRepository
import id.aej.jeky.core.domain.repository.UserRepository
import id.aej.jeky.core.domain.usecase.AuthUseCase
import id.aej.jeky.core.domain.usecase.PlacesUseCase
import id.aej.jeky.core.domain.usecase.UserUseCase
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

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

  private fun retrofitClient(): OkHttpClient {
    val logging = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    return OkHttpClient.Builder().addInterceptor(logging).build()
  }

  private val retrofitPlaces: Retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create())
    .baseUrl("https://places.googleapis.com")
    .client(retrofitClient())
    .build()

  private val jekyApiService: JekyService by lazy {
    retrofitPlaces.create(JekyService::class.java)
  }

  override val authRepository: AuthRepository
    get() = AuthRepositoryImpl(jekyDatabase.userDao())

  override val userRepository: UserRepository
    get() = UserRepositoryImpl(jekyDataStore)

  override val placesRepository: PlacesRepository
    get() = PlacesRepositoryImpl(jekyApiService)

  override val authUseCase: AuthUseCase
    get() = AuthInteractor(authRepository)

  override val userUseCase: UserUseCase
    get() = UserInteractor(userRepository)

  override val placesUseCase: PlacesUseCase
    get() = PlacesInteractor(placesRepository)
}