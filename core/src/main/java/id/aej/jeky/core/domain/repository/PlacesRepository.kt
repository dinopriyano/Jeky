package id.aej.jeky.core.domain.repository

import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.data.source.remote.dto.response.PlacesResponse
import id.aej.jeky.core.domain.model.User
import kotlinx.coroutines.flow.Flow

/**
 * Created by dino.priyano on 20/08/23.
 */
interface PlacesRepository {
  suspend fun getPlaces(keyword: String): Flow<Resource<PlacesResponse>>
}