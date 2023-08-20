package id.aej.jeky.core.data.interactors

import id.aej.jeky.core.data.source.Resource
import id.aej.jeky.core.data.source.remote.dto.response.PlacesResponse
import id.aej.jeky.core.domain.repository.PlacesRepository
import id.aej.jeky.core.domain.usecase.PlacesUseCase
import kotlinx.coroutines.flow.Flow

/**
 * Created by dino.priyano on 20/08/23.
 */
class PlacesInteractor constructor(
  private val repository: PlacesRepository
): PlacesUseCase {
  override suspend fun getPlaces(keyword: String): Flow<Resource<PlacesResponse>> {
    return repository.getPlaces(keyword)
  }
}