package id.aej.jeky.core.data.source.remote.network

import id.aej.jeky.core.data.source.remote.dto.response.PlacesResponse
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query

/**
 * Created by dino.priyano on 20/08/23.
 */
interface JekyService {

  @Headers(
    "X-Goog-Api-Key: AIzaSyBu6mS62zBS9zSu4NFxKWcJZKqzgfh-8d0",
    "X-Goog-FieldMask: places.displayName,places.formattedAddress,places.priceLevel,places.location"
  )
  @POST("v1/places:searchText")
  suspend fun getPlaces(
    @Query("textQuery") textQuery: String
  ): PlacesResponse

}