package id.aej.jeky.core.data.repository

import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.data.source.remote.SafeApiCall
import id.aej.jeky.core.data.source.remote.dto.response.PlacesResponse
import id.aej.jeky.core.data.source.remote.network.JekyService
import id.aej.jeky.core.domain.repository.PlacesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

/**
 * Created by dino.priyano on 20/08/23.
 */
class PlacesRepositoryImpl constructor(
  private val apiService: JekyService
): PlacesRepository, SafeApiCall {

  override suspend fun getPlaces(keyword: String): Flow<Resource<PlacesResponse>> {
    return flow {
      emit( safeApiCall { apiService.getPlaces(keyword) } )
    }
  }

}