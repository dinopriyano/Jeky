package id.aej.jeky.core.domain.usecase

import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.data.source.remote.dto.request.LatLng
import id.aej.jeky.core.data.source.remote.dto.response.PlacesResponse
import id.aej.jeky.core.data.source.remote.dto.response.RoutesResponse
import kotlinx.coroutines.flow.Flow

/**
 * Created by dino.priyano on 20/08/23.
 */
interface PlacesUseCase {
  suspend fun getPlaces(keyword: String): Flow<Resource<PlacesResponse?>>
  suspend fun getPlaceRoutes(
    origin: LatLng,
    destination: LatLng
  ): Flow<Resource<RoutesResponse>>
}