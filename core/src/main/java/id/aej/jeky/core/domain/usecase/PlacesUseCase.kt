package id.aej.jeky.core.domain.usecase

import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.data.source.remote.dto.response.GetPlacesRoutesResponse
import id.aej.jeky.core.data.source.remote.dto.response.PlacesResponse
import id.aej.jeky.core.domain.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Created by dino.priyano on 20/08/23.
 */
interface PlacesUseCase {
  suspend fun getPlaces(keyword: String): Flow<Resource<PlacesResponse?>>
  suspend fun getPlaceRoutes(origin: String, destination: String): Flow<Resource<GetPlacesRoutesResponse>>
}