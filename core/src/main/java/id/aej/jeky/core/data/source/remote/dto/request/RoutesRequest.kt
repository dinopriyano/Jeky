package id.aej.jeky.core.data.source.remote.dto.request

import com.google.gson.annotations.SerializedName

data class RoutesRequest(

	@field:SerializedName("origin")
	val origin: Origin? = null,

	@field:SerializedName("destination")
	val destination: Destination? = null
)

data class LatLng(

	@field:SerializedName("latitude")
	val latitude: Any? = null,

	@field:SerializedName("longitude")
	val longitude: Any? = null
)

data class Origin(

	@field:SerializedName("location")
	val location: Location? = null
)

data class Location(

	@field:SerializedName("latLng")
	val latLng: LatLng? = null
)

data class Destination(

	@field:SerializedName("location")
	val location: Location? = null
)
