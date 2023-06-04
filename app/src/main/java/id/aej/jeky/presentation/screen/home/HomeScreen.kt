package id.aej.jeky.presentation.screen.home

import android.Manifest
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.MapUiSettings
import id.aej.jeky.R
import id.aej.jeky.presentation.component.PointField
import id.aej.jeky.presentation.theme.Primary

/**
 * Created by dino.priyano on 07/05/23.
 */

@OptIn(ExperimentalPermissionsApi::class) @Composable fun HomeScreen(
  onEditButtonClick: () -> Unit
) {

  val locationPermissionState = rememberMultiplePermissionsState(
    listOf(
      Manifest.permission.ACCESS_COARSE_LOCATION,
      Manifest.permission.ACCESS_FINE_LOCATION
    )
  )

  var pickup by remember {
    mutableStateOf("")
  }
  var destination by remember {
    mutableStateOf("")
  }

  if(locationPermissionState.allPermissionsGranted) {
    Box(modifier = Modifier.fillMaxSize()) {
      GoogleMap(
        modifier = Modifier.fillMaxSize(),
        uiSettings = MapUiSettings(zoomControlsEnabled = false, compassEnabled = false)
      ) {

      }
      PointField(modifier = Modifier
        .fillMaxWidth()
        .padding(top = 40.dp)
        .padding(horizontal = 24.dp),
        readOnly = true,
        pickupValue = pickup,
        destinationValue = destination,
        pickupPlaceholder = stringResource(id = R.string.pickup_location_txt),
        destinationPlaceholder = stringResource(R.string.destination_location_txt),
        onPickupFocused = {},
        onDestinationFocused = {},
        onEditButtonClick = {
          // TODO: open pick location bottom sheet
          onEditButtonClick.invoke()
        }
      )
    }
  } else {
    Column(modifier = Modifier.fillMaxSize(), verticalArrangement = Arrangement.Center) {
      Text(
        text = stringResource(R.string.location_permission_message),
        style = MaterialTheme.typography.bodySmall,
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp)
          .padding(top = 16.dp)
      )
      Button(
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 16.dp)
          .padding(top = 24.dp, bottom = 16.dp),
        shape = RoundedCornerShape(15.dp),
        colors = ButtonDefaults.buttonColors(
          contentColor = Color.White,
          containerColor = Primary
        ),
        onClick = {
          locationPermissionState.launchMultiplePermissionRequest()
        },
        contentPadding = PaddingValues(vertical = 16.dp)
      ) {
        Text(
          text = stringResource(R.string.allow_permission),
          style = MaterialTheme.typography.labelSmall
        )
      }
    }
  }
}