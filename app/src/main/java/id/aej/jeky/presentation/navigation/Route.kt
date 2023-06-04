package id.aej.jeky.presentation.navigation

/**
 * Created by dino.priyano on 07/05/23.
 */
sealed class Route(val route: String) {
  object Login: Route("login")
  object Register: Route("register")
  object Home: Route("home")
  object PickLocationBottomSheet: Route("pick-location")
}
