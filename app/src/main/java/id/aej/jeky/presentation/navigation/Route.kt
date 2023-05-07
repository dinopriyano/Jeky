package id.aej.jeky.presentation.navigation

/**
 * Created by dino.priyano on 07/05/23.
 */
sealed class Route(val route: String) {
  object Login: Route("Login")
  object Register: Route("Register")
  object Home: Route("Home")
}
