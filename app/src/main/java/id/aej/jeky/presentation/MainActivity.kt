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
import id.aej.jeky.presentation.component.TextHeader
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
  TextHeader(
    modifier = Modifier.fillMaxSize(),
    headerText = "Selamat Datang",
    supportText = "Masukkan email dan password dari akun yang pernah kamu buat sebelumnya"
  )
}
