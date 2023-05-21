package id.aej.jeky.presentation.screen.home

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.google.maps.android.compose.GoogleMap

/**
 * Created by dino.priyano on 07/05/23.
 */

@Composable fun HomeScreen(
  navHostController: NavHostController
) {

  Box(modifier = Modifier.fillMaxSize()) {
    GoogleMap {
    }
  }

}