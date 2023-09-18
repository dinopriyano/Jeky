package id.aej.jeky.core.data.source.remote.dto.response

import com.google.gson.annotations.SerializedName
import java.security.interfaces.DSAPublicKey

data class GetPlacesRoutesResponse(

	@field:SerializedName("routes")
	val routes: List<RoutesItem?>? = null,

	@field:SerializedName("geocoded_waypoints")
	val geocodedWaypoints: List<GeocodedWaypointsItem?>? = null,

	@field:SerializedName("status")
	val status: String? = null
)

data class GeocodedWaypointsItem(

	@field:SerializedName("types")
	val types: List<String?>? = null,

	@field:SerializedName("geocoder_status")
	val geocoderStatus: String? = null,

	@field:SerializedName("place_id")
	val placeId: String? = null
)

data class Bounds(

	@field:SerializedName("southwest")
	val southwest: Southwest? = null,

	@field:SerializedName("northeast")
	val northeast: Northeast? = null
)

data class Distance(

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("value")
	val value: Int? = null
)

data class EndLocation(

	@field:SerializedName("lng")
	val lng: Double? = null,

	@field:SerializedName("lat")
	val lat: Double? = null
)

data class StartLocation(

	@field:SerializedName("lng")
	val lng: Double? = null,

	@field:SerializedName("lat")
	val lat: Double? = null
)

data class Polyline(

	@field:SerializedName("points")
	val points: String? = null
)

data class LegsItem(

	@field:SerializedName("duration")
	val duration: Duration? = null,

	@field:SerializedName("start_location")
	val startLocation: StartLocation? = null,

	@field:SerializedName("distance")
	val distance: Distance? = null,

	@field:SerializedName("start_address")
	val startAddress: String? = null,

	@field:SerializedName("end_location")
	val endLocation: EndLocation? = null,

	@field:SerializedName("end_address")
	val endAddress: String? = null,

	@field:SerializedName("via_waypoint")
	val viaWaypoint: List<Any?>? = null,

	@field:SerializedName("steps")
	val steps: List<StepsItem?>? = null,

	@field:SerializedName("traffic_speed_entry")
	val trafficSpeedEntry: List<Any?>? = null
)

data class RoutesItem(

	@field:SerializedName("summary")
	val summary: String? = null,

	@field:SerializedName("copyrights")
	val copyrights: String? = null,

	@field:SerializedName("legs")
	val legs: List<LegsItem?>? = null,

	@field:SerializedName("warnings")
	val warnings: List<Any?>? = null,

	@field:SerializedName("bounds")
	val bounds: Bounds? = null,

	@field:SerializedName("overview_polyline")
	val overviewPolyline: OverviewPolyline? = null,

	@field:SerializedName("waypoint_order")
	val waypointOrder: List<Any?>? = null
)

data class Southwest(

	@field:SerializedName("lng")
	val lng: Any? = null,

	@field:SerializedName("lat")
	val lat: Any? = null
)

data class StepsItem(

	@field:SerializedName("duration")
	val duration: Duration? = null,

	@field:SerializedName("start_location")
	val startLocation: StartLocation? = null,

	@field:SerializedName("distance")
	val distance: Distance? = null,

	@field:SerializedName("travel_mode")
	val travelMode: String? = null,

	@field:SerializedName("html_instructions")
	val htmlInstructions: String? = null,

	@field:SerializedName("end_location")
	val endLocation: EndLocation? = null,

	@field:SerializedName("maneuver")
	val maneuver: String? = null,

	@field:SerializedName("polyline")
	val polyline: Polyline? = null
)

data class Duration(

	@field:SerializedName("text")
	val text: String? = null,

	@field:SerializedName("value")
	val value: Int? = null
)

data class Northeast(

	@field:SerializedName("lng")
	val lng: Any? = null,

	@field:SerializedName("lat")
	val lat: Any? = null
)

data class OverviewPolyline(

	@field:SerializedName("points")
	val points: String? = null
)
