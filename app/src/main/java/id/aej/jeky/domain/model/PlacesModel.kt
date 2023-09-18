package id.aej.jeky.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

/**
 * Created by dino.priyano on 18/09/23.
 */

@Parcelize
data class PlacesModel(
  val locationName: String = "",
  val latitude: Double = 0.0,
  val longitude: Double = 0.0,
  val isPickupLocation: Boolean = true
): Parcelable
