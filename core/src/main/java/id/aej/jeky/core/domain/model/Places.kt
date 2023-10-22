package id.aej.jeky.core.domain.model

import com.google.gson.annotations.SerializedName

data class Places(

	@field:SerializedName("places")
	val places: List<PlacesItem>
)

data class Location(

	@field:SerializedName("latitude")
	val latitude: Double,

	@field:SerializedName("longitude")
	val longitude: Double
)

data class DisplayName(

	@field:SerializedName("text")
	val text: String?,

	@field:SerializedName("languageCode")
	val languageCode: String?
)

data class PlacesItem(

	@field:SerializedName("formattedAddress")
	val formattedAddress: String?,

	@field:SerializedName("displayName")
	val displayName: DisplayName?,

	@field:SerializedName("location")
	val location: Location?
)
