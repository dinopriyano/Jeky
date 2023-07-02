package id.aej.jeky.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material.rememberModalBottomSheetState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ExperimentalMaterialNavigationApi
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import com.google.accompanist.navigation.material.bottomSheet
import com.google.accompanist.navigation.material.rememberBottomSheetNavigator
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import id.aej.jeky.presentation.navigation.Route
import id.aej.jeky.presentation.screen.home.HomeScreen
import id.aej.jeky.presentation.screen.login.LoginScreen
import id.aej.jeky.presentation.screen.login.LoginViewModel
import id.aej.jeky.presentation.screen.pick_location.PickLocationBottomSheet
import id.aej.jeky.presentation.screen.register.RegisterScreen
import id.aej.jeky.presentation.screen.register.RegisterViewModel
import id.aej.jeky.presentation.theme.JekyTheme

@ExperimentalMaterial3Api @ExperimentalComposeUiApi class MainActivity : ComponentActivity() {
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    installSplashScreen().apply {
      setKeepOnScreenCondition {
        false
      }
    }
    setContent {
      JekyTheme { // A surface container using the 'background' color from the theme
        JekyApps()
      }
    }
  }
}

@OptIn(ExperimentalMaterialNavigationApi::class, ExperimentalMaterialApi::class)
@ExperimentalComposeUiApi @ExperimentalMaterial3Api @Composable fun JekyApps() {
  val sheetState = rememberModalBottomSheetState(
    ModalBottomSheetValue.Hidden,
    skipHalfExpanded = true
  )
  val bottomSheetNavigator = remember { BottomSheetNavigator(sheetState) }
  val navController = rememberNavController(bottomSheetNavigator)

  ModalBottomSheetLayout(
    bottomSheetNavigator = bottomSheetNavigator
  ) {
    NavHost(navController = navController, startDestination = Route.Login.route) {
      composable(
        route = Route.Login.route
      ) {
        val viewModel: LoginViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = LoginViewModel.Factory)
        LoginScreen(
          viewModel = viewModel,
          onNavigateToHome = {
            navController.navigate(Route.Home.route)
          },
          onNavigateToRegister = {
            navController.navigate(Route.Register.route)
          }
        )
      }

      composable(
        route = Route.Register.route
      ) {
        val viewModel: RegisterViewModel = androidx.lifecycle.viewmodel.compose.viewModel(factory = RegisterViewModel.Factory)
        RegisterScreen(
          viewModel = viewModel,
          onNavigateBack = {
            navController.popBackStack()
          },
          onNavigateToHome = {
            navController.navigate(Route.Home.route)
          }
        )
      }

      composable(
        route = Route.Home.route
      ) {
        HomeScreen(
          onEditButtonClick = {
            navController.navigate("${Route.PickLocationBottomSheet.route}/true")
          }
        )
      }

      bottomSheet(
        route = "${Route.PickLocationBottomSheet.route}/{isToGetPickupLocation}",
        arguments = listOf(
          navArgument("isToGetPickupLocation") { type = NavType.BoolType }
        )
      ) { backStackEntry ->
        val isToGetPickupLocation = backStackEntry.arguments?.getBoolean("isToGetPickupLocation") ?: true
        PickLocationBottomSheet(
          isToGetPickupLocation,
          onClose = {
            navController.popBackStack()
          }
        )
      }

    }
  }
}
