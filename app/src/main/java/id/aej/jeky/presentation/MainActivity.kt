package id.aej.jeky.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import id.aej.jeky.presentation.component.TextHeader
import id.aej.jeky.presentation.navigation.Route
import id.aej.jeky.presentation.screen.home.HomeScreen
import id.aej.jeky.presentation.screen.login.LoginScreen
import id.aej.jeky.presentation.screen.register.RegisterScreen
import id.aej.jeky.presentation.theme.JekyTheme

class MainActivity : ComponentActivity() {
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

@Composable fun JekyApps() {
  val navController = rememberNavController()
  NavHost(navController = navController, startDestination = Route.Login.route) {
    composable(
      route = Route.Login.route
    ) {
      LoginScreen(navController)
    }

    composable(
      route = Route.Register.route
    ) {
      RegisterScreen(navController)
    }

    composable(
      route = Route.Home.route
    ) {
      HomeScreen(navController)
    }

  }
}
